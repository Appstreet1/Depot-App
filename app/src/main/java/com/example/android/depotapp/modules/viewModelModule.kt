package com.example.android.depotapp.modules

import com.example.android.depotapp.ui.selectdepot.SelectDepotViewModel
import org.koin.android.viewmodel.compat.ViewModelCompat.viewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        SelectDepotViewModel(repository = get())
    }

}