package com.example.android.depotapp.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ShareDetails(
    @Json(name = "logo") val logo: String,
    @Json(name = "country") val country: String,
    @Json(name = "industry") val industry: String,
    @Json(name = "sector") val sector: String,
    @Json(name = "description") val description: String,
    @Json(name = "name") val name: String,
    @Json(name = "employees") val employees: Int,
    )
