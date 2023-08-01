package com.learn.assignment.data.remote

import com.learn.assignment.data.model.ImagesListResponse
import com.learn.assignment.utils.Constants
import com.learn.assignment.utils.Constants.PAGINATION.PER_PAGE
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Query


interface APICallMethods {

    @GET("api/")
    fun getImages(
        @Query("key")key:String = Constants.API_KEY,
        @Query("q") searchValue:String? = "",
        @Query("per_page") size: Int = PER_PAGE,
        @Query("page") page: Int,
    ): Call<ImagesListResponse>

}
