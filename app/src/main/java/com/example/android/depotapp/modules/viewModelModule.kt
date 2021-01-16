package com.example.android.depotapp.modules

import com.example.android.depotapp.ui.adddepot.AddDepotViewModel
import com.example.android.depotapp.ui.addshare.AddShareViewModel
import com.example.android.depotapp.ui.depotoverview.DepotOverviewViewModel
import com.example.android.depotapp.ui.detailShare.ShareDetailViewModel
import com.example.android.depotapp.ui.selectdepot.SelectDepotViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { SelectDepotViewModel(repository = get()) }
    viewModel { AddDepotViewModel(repository = get()) }
    viewModel { DepotOverviewViewModel(shareRepo = get()) }
    viewModel { AddShareViewModel(shareRepo = get()) }
    viewModel { ShareDetailViewModel(shareRepository = get()) }

}