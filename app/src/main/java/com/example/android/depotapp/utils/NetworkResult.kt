package com.example.android.depotapp.utils

import com.example.android.depotapp.network.ShareDTO
import java.lang.Exception

sealed class NetworkResult{
    data class Success(val share : ShareDTO) : NetworkResult()
    data class Error(val exception: Exception) : NetworkResult()
}
