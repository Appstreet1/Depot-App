package com.example.android.depotapp.database.depot

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.android.depotapp.database.converter.DateConverter
import com.example.android.depotapp.database.purchase.PurchaseDao
import com.example.android.depotapp.database.purchase.PurchaseDatabaseItem
import com.example.android.depotapp.database.share.ShareDao
import com.example.android.depotapp.database.share.ShareDatabaseItem

@Database(
    entities = [DepotDatabaseItem::class, ShareDatabaseItem::class, PurchaseDatabaseItem::class],
    version = 1, exportSchema = false
)

@TypeConverters(DateConverter::class)
abstract class DepotDatabase : RoomDatabase() {
    abstract val depotDao: DepotDao
    abstract val shareDao: ShareDao
    abstract val purchaseDao: PurchaseDao

    companion object {
        private lateinit var INSTANCE: DepotDatabase

        fun getDatabase(context: Context): DepotDatabase {
            synchronized(DepotDatabase::class.java) {
                if (!::INSTANCE.isInitialized) {
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

