package com.learn.assignment.repository.images

import com.learn.assignment.data.model.ImagesListResponse
import com.learn.assignment.data.remote.APICallMethods
import com.learn.assignment.utils.CustomException
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ImagesRepoImpl():ImagesRepo {
    override fun getImageList(
        apiCallMethods: APICallMethods,
        searchString:String,
        page:Int,
        onSuccess: (ImagesListResponse) -> Unit,
        onError: (Exception?) -> Unit
    ){
        apiCallMethods.getImages(searchValue = searchString, page = page).enqueue(object :
            Callback<ImagesListResponse> {
            override fun onResponse(
                call: Call<ImagesListResponse>,
                response: Response<ImagesListResponse>
            ) {
                if (response.isSuccessful) {
                    val imagesListResponse = response.body()
                    onSuccess(imagesListResponse!!)

                } else {
                    onError(CustomException())

                }
            }

            override fun onFailure(call: Call<ImagesListResponse>, t: Throwable) {
                onError(CustomException(t.message))

            }

        })
    }

}