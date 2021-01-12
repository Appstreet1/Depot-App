package com.example.android.depotapp.modules

import com.example.android.depotapp.repository.depot.DepotRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { DepotRepository(dao = get()) }
}