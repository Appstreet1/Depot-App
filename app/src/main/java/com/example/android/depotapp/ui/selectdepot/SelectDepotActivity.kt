package com.example.android.depotapp.ui.selectdepot

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android.depotapp.R

class SelectDepotActivity : AppCompatActivity() {

    private lateinit var selectDepotViewModel: SelectDepotViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_depot)


    }
}