package com.sg.mytest.sgmobiledatausage.presentation.sgmobiledata

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sg.mytest.sgmobiledatausage.FakeGetSGMobileDataUsageUseCaseImpl
import com.sg.mytest.sgmobiledatausage.FakeRetrieveCachedSGMobileDataUsageUseCaseImpl
import com.sg.mytest.sgmobiledatausage.MainCoroutineRule
import com.sg.mytest.sgmobiledatausage.data.repository.SGMobileRepository
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

    private lateinit var viewModel: SGMobileDataUsageViewModel

    @Before
    fun setUp() {
        viewModel = SGMobileDataUsageViewModel(
            ApplicationProvider.getApplicationContext(),
            FakeGetSGMobileDataUsageUseCaseImpl(ApplicationProvider.getApplicationContext()),
            FakeRetrieveCachedSGMobileDataUsageUseCaseImpl()
        )
    }

    @Test
    fun test_fetchDataFromNetwork_Success() = mainCoroutineRule.runBlockingTest {
        viewModel.fetchDataFromNetwork()

        val result = viewModel.mobileDataInfoByYear.getOrAwaitValue()
        assertNotNull(result)
        assertNotEquals(result.size, 0)
    }

    @Test
    fun test_fetchDataFromLocal_Success() = mainCoroutineRule.runBlockingTest {
        viewModel.fetchDataFromLocal()

        val result = viewModel.mobileDataInfoByYear.getOrAwaitValue()
        assertNotNull(result)
        assertNotEquals(result.size, 0)
    }
}