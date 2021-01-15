package com.example.android.depotapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.android.depotapp.database.converter.DateTypeConverter
import com.example.android.depotapp.database.dao.DepotDao
import com.example.android.depotapp.database.dao.ShareDao
import com.example.android.depotapp.database.entities.DepotDatabaseItem
import com.example.android.depotapp.database.entities.ShareDatabaseItem

@Database(
    entities = [DepotDatabaseItem::class, ShareDatabaseItem::class],
    version = 1, exportSchema = false
)

@TypeConverters(DateTypeConverter::class)
abstract class DepotDatabase : RoomDatabase() {
    abstract val depotDao: DepotDao
    abstract val shareDao: ShareDao

    companion object {
        private lateinit var INSTANCE: DepotDatabase

        fun getDatabase(context: Context): DepotDatabase {
            synchronized(DepotDatabase::class.java) {
                if (!Companion::INSTANCE.isInitialized) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        DepotDatabase::class.java,
                        "depotsDatabase"
                    ).build()
                }
            }
            return INSTANCE
        }
    }
}

