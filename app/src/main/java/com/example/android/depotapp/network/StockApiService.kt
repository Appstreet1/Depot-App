package com.example.android.depotapp.network

import com.example.android.depotapp.BuildConfig
import com.example.android.depotapp.utils.const.BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.*


private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface StockApiService {

    @GET("v1/open-close/{symbol}/{date}")
    suspend fun getShare(
        @Path("symbol") symbol: String,
        @Path("date") date: String,
        @Query("apiKey") apiKey: String
    ): ShareDTO

    @GET("v1/meta/symbols/{symbol}/company")
    suspend fun getShareTitleBySymbol(
        @Path("symbol") symbol: String,
        @Query("apiKey") apiKey: String
    ) : Title
}

object StockApi {
    val retrofitService: StockApiService by lazy {
        retrofit.create(StockApiService::class.java)
    }
}