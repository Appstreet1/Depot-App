package com.example.android.depotapp.model

class Depot(
    id : Long,
    title: String,
    purchases: List<Purchase>,
    value: Double,
    valueIncrease: Double
)