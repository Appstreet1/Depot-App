package com.example.android.depotapp.network

import com.example.android.depotapp.utils.const.BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

interface StockApiService {

    @GET("v1/open-close/{symbol}/{date}")
    suspend fun getShareAsync(
        @Path("symbol") symbol: String,
        @Path("date") date: String,
        @Query("apiKey") apiKey: String
    ): ShareDTO

    @GET("v1/meta/symbols/{symbol}/company")
    suspend fun getShareTitleBySymbol(
        @Path("symbol") symbol: String,
        @Query("apiKey") apiKey: String
    ): Title
}

object StockApi {
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .build()

    val retrofitService: StockApiService by lazy {
        retrofit.create(StockApiService::class.java)
    }
}