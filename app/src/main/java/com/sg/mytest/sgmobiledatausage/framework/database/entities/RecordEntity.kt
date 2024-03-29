package com.sg.mytest.sgmobiledatausage.framework.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sg.mytest.sgmobiledatausage.domain.entities.Record

@Entity(tableName = "record_entity")
data class RecordEntity(
    @ColumnInfo(name = "volume_of_mobile_data")
    val volumeOfMobileData: String,
    @ColumnInfo(name = "quarter")
    val quarter: String,
    @PrimaryKey
    @ColumnInfo(name = "_id")
    val recordId: Int
)

fun List<RecordEntity>.asDomainModel(): List<Record> {
    return map {
        Record(
            volumeOfMobileData = it.volumeOfMobileData,
            quarter = it.quarter,
            id = it.recordId
        )
    }
}

fun List<Record>.asDatabaseModel(): List<RecordEntity> {
    return map {
        RecordEntity(
            volumeOfMobileData = it.volumeOfMobileData,
            quarter = it.quarter,
            recordId = it.id
        )
    }
}