package com.example.android.depotapp.model

import java.util.*

class Purchase(
    val purchaseId : Long ,
    val titleOfShare: String,
    val amountOfShares: Double,
    val totalValue: Double,
    val dateOfPurchase : String,
    val valueIncrease: Double,
    val depotId : Long
)