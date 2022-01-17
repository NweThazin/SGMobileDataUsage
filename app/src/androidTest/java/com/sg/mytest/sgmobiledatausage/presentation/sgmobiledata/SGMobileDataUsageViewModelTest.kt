package com.sg.mytest.sgmobiledatausage.presentation.sgmobiledata

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.gson.Gson
import com.sg.mytest.sgmobiledatausage.MainCoroutineRule
import com.sg.mytest.sgmobiledatausage.R
import com.sg.mytest.sgmobiledatausage.domain.interactors.GetSGMobileDataUsageUseCase
import org.mockito.Mockito.`when`
import com.sg.mytest.sgmobiledatausage.domain.interactors.RetrieveCachedSGMobileDataUsageUseCase
import com.sg.mytest.sgmobiledatausage.framework.database.entities.RecordEntity
import com.sg.mytest.sgmobiledatausage.framework.database.entities.asDomainModel
import com.sg.mytest.sgmobiledatausage.framework.network.model.ApiStatus
import com.sg.mytest.sgmobiledatausage.framework.network.model.GetSGMobileDataUsageResponse
import com.sg.mytest.sgmobiledatausage.getOrAwaitValue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.*
import org.junit.Assert.*

import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class SGMobileDataUsageViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    // set the main coroutines dispatcher for unit testing
    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @Mock
    private lateinit var useCase: GetSGMobileDataUsageUseCase

    @Mock
    private lateinit var retrieveUseCase: RetrieveCachedSGMobileDataUsageUseCase

    private lateinit var viewModel: SGMobileDataUsageViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        viewModel = SGMobileDataUsageViewModel(
            ApplicationProvider.getApplicationContext(),
            useCase,
            retrieveUseCase
        )
    }

    @Test
    fun test_fetchDataFromNetwork_Success() = mainCoroutineRule.runBlockingTest {
        `when`(useCase.invoke()).thenReturn(Result.success(loadMockData(ApplicationProvider.getApplicationContext())))
        viewModel.fetchDataFromNetwork()

        val result = viewModel.mobileDataInfoByYear.getOrAwaitValue()
        assertNotNull(result)
        assertNotEquals(result.size, 0)
        assertEquals(viewModel.apiStatus.getOrAwaitValue(), ApiStatus.SUCCESS)
    }

    @Test
    fun test_fetchDataFromLocal_Success() = mainCoroutineRule.runBlockingTest {
        val records = listOf(
            RecordEntity("0.000384", "2010-Q3", 1),
            RecordEntity("0.000543", "2010-Q4", 2),
            RecordEntity("0.000543", "2011-Q1", 3),
            RecordEntity("0.000634", "2011-Q2", 4),
            RecordEntity("0.000634", "2011-Q3", 5)
        )
        `when`(retrieveUseCase.invoke()).thenReturn(records.asDomainModel())

        viewModel.fetchDataFromLocal()

        val result = viewModel.mobileDataInfoByYear.getOrAwaitValue()
        assertNotNull(result)
        assertNotEquals(result.size, 0)
        assertEquals(viewModel.apiStatus.getOrAwaitValue(), ApiStatus.SUCCESS)
    }

    private fun loadMockData(context: Context): GetSGMobileDataUsageResponse {
        val jsonString = context.resources.openRawResource(R.raw.mock_test_get_sg_mobile)
            .bufferedReader().use { it.readText() }
        return Gson().fromJson(jsonString, GetSGMobileDataUsageResponse::class.java)
    }
}