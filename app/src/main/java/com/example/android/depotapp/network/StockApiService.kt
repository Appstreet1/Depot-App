package com.example.android.depotapp.network

import com.example.android.depotapp.BuildConfig.API_KEY
import com.example.android.depotapp.BuildConfig.BASE_URL
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

//TODO: hide it in local.properties

private const val API_KEY = API_KEY
private const val BASE_URL = BASE_URL

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl("BuildConfig.")
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