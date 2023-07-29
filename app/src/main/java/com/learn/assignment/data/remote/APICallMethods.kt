package com.learn.assignment.data.remote

import com.learn.assignment.data.model.ImagesListResponse
import com.learn.assignment.utils.Constants
import io.reactivex.Single
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Query


interface APICallMethods {

    @GET
    fun getImages(
        @Query("key")key:String = Constants.API_KEY,
        @Query("q") searchValue:String? = ""
    ):Single<ImagesListResponse>

}
