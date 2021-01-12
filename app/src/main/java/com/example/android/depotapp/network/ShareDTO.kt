package com.example.android.depotapp.network

import com.example.android.depotapp.database.entities.ShareDatabaseItem
import com.example.android.depotapp.model.Share
import com.squareup.moshi.JsonClass

/**
DTO = DataTransferObjects -> responsible for paring response from the server or formatting objects to send to the server
 */

@JsonClass(generateAdapter = true)
data class NetworkShareContainer(val shares: List<NetworkShare>)

@JsonClass(generateAdapter = true)
data class NetworkShare(
    val symbol : String,
    val title: String,
    val price : Double,



/**
 * Convert Network results to database objects
 */
fun NetworkShareContainer.asDomainModel(): List<Share> {
    return shares.map {
        Share(
            title = it.title,

    }
}

fun NetworkShareContainer.asDatabaseModel(): Array<ShareDatabaseItem> {
    return shares.map {
        Share(
            title = it.title,
            description = it.description,
            url = it.url,
            updated = it.updated,
            thumbnail = it.thumbnail)
    }.toTypedArray()
}