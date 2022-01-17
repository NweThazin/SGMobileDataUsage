package com.sg.mytest.sgmobiledatausage.framework.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sg.mytest.sgmobiledatausage.framework.database.entities.RecordEntity

@Dao
interface SGMobileDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecord(record: RecordEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllRecords(records: List<RecordEntity>): List<Long>

    @Query("SELECT * FROM record_entity")
    suspend fun getAllRecords(): List<RecordEntity>

    @Query("DELETE FROM record_entity")
    suspend fun clearAll()
}