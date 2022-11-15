package com.assignment.imageList

import com.assignment.network.RetrofitBuilder


class ImageListRepository {

    val client = RetrofitBuilder.instant

    suspend fun getImageList() = client.getImageList("nukJ0B2kWgyLRxIcyRATNMK4sHz5fCvU")

}