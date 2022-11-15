package com.assignment.network

import com.assignment.imageList.model.ImageModel
import retrofit2.http.*

interface RetrofitClient {

    @GET(Urls.LIST_IMAGES)
    suspend fun getImageList(
        @Query("api-key") key :String
    ): NetworkResponse<ImageModel, ErrorModel>

}
