package com.sg.mytest.sgmobiledatausage.framework.database

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sg.mytest.sgmobiledatausage.framework.database.entities.RecordEntity
import kotlinx.coroutines.runBlocking
import org.junit.*
import org.junit.runner.RunWith
import java.io.IOException
import kotlin.jvm.Throws

@RunWith(AndroidJUnit4::class)
class SGMobileDatabaseDaoTest {

    private lateinit var database: SGMobileUsageDatabase
    private lateinit var dao: SGMobileDatabaseDao

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            SGMobileUsageDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.databaseDao
    }

    @After
    @Throws(IOException::class)
    fun tearDown() {
        database.close()
    }

    @Test
    fun test_insertRecord() = runBlocking {
        val recordEntity = RecordEntity(
            volumeOfMobileData = "0.00062",
            quarter = "2010-Q1",
            recordId = 1
        )
        dao.insertRecord(recordEntity)

        val list = dao.getAllRecords()
        Assert.assertEquals(list.size, 1)
    }

    @Test
    fun test_insertAllRecords() = runBlocking {
        val list = listOf(
            RecordEntity(
                volumeOfMobileData = "0.00062",
                quarter = "2010-Q1",
                recordId = 1
            ), RecordEntity(
                volumeOfMobileData = "0.00025",
                quarter = "2010-Q2",
                recordId = 2
            )
        )
        dao.insertAllRecords(list)
        val insertedRecords = dao.getAllRecords()
        Assert.assertEquals(insertedRecords.size, list.size)
    }

    @Test
    fun test_clearAllRecords() = runBlocking {
        val list = listOf(
            RecordEntity(
                volumeOfMobileData = "0.00062",
                quarter = "2010-Q1",
                recordId = 1
            ), RecordEntity(
                volumeOfMobileData = "0.00025",
                quarter = "2010-Q2",
                recordId = 2
            )
        )
        dao.insertAllRecords(list)
        dao.clearAll()
        val insertedRecords = dao.getAllRecords()
        Assert.assertEquals(insertedRecords.size, 0)
    }
}