package com.example.android.depotapp

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.depotapp.modules.databaseModule
import com.example.android.depotapp.modules.repositoryModule
import com.example.android.depotapp.modules.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DepotApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@DepotApplication)
            modules(databaseModule, repositoryModule, viewModelModule)
        }
    }
}