package com.example.android.depotapp.modules

import android.app.Application
import androidx.room.Room
import com.example.android.depotapp.database.dao.DepotDao
import com.example.android.depotapp.database.DepotDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {

    fun provideDatabase(application: Application): DepotDatabase {
        return Room.databaseBuilder(application, DepotDatabase::class.java, "depots")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideDepotDao(database: DepotDatabase): DepotDao {
        return  database.depotDao
    }

//    single { provideDatabase(androidApplication()) }
//    single { provideDepotDao(get()) }

    single { DepotDatabase.getDatabase(androidApplication()) }
//    single { DepotDatabase.getDatabase(androidApplication()).depotDao }
}