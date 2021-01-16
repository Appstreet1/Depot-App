package com.example.android.depotapp.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ShareDetails(
    val logo: String,
    val country: String,
    val industry: String,
    val sector: String,
    val description: String,
    val name: String,
    val employees: Int,
)
