package com.example.android.depotapp.modules

import android.content.Context
import com.example.android.depotapp.database.depot.DepotDao
import com.example.android.depotapp.repository.depot.DepotRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {
    single { DepotRepository(dao = get()) }
}