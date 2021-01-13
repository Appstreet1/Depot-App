package com.example.android.depotapp.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Title(
    @Json(name = "name") val title: String,
)