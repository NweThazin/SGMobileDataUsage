package com.sg.mytest.sgmobiledatausage.framework.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sg.mytest.sgmobiledatausage.framework.database.entities.RecordEntity

@Database(
    entities = [RecordEntity::class],
    version = 1,
    exportSchema = false
)
abstract class SGMobileUsageDatabase : RoomDatabase() {
    abstract val databaseDao: SGMobileDatabaseDao

    companion object {
        @Volatile
        private var INSTANCE: SGMobileUsageDatabase? = null

        fun getInstance(context: Context): SGMobileUsageDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        SGMobileUsageDatabase::class.java,
                        "sg_mobile_data_usage_database"
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}