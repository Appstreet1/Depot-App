package com.example.android.depotapp.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

//TODO: hide it in local.properties
private const val BASE_URL = "https://api.polygon.io/v1/open-close/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface StockApiService {
    @GET("AAPL/2020-10-14?apiKey=*")

    fun getProperties(): Call<String>

}

object StockApi {
    val retrofitService: StockApiService by lazy {
        retrofit.create(StockApiService::class.java)
    }
}