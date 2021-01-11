package com.example.android.depotapp.modules

import android.app.Application
import androidx.room.Room
import com.example.android.depotapp.database.dao.DepotDao
import com.example.android.depotapp.database.DepotDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {

    single { DepotDatabase.getDatabase(androidApplication()) }
    single { DepotDatabase.getDatabase(androidApplication()).depotDao }
}