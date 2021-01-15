package com.example.android.depotapp.modules

import com.example.android.depotapp.repository.depot.DepotRepository
import com.example.android.depotapp.repository.share.ShareRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { DepotRepository(dao = get()) }
    single { ShareRepository(dao = get()) }
}