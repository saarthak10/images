package com.learn.assignment.repository.images

import com.learn.assignment.data.model.ImagesListResponse
import com.learn.assignment.data.remote.APICallMethods

interface ImagesRepo {
    fun getImageList(apiCallMethods: APICallMethods,
                     searchString:String,
                     page:Int,
                     onSuccess: (ImagesListResponse) -> Unit,
                     onError: (Exception?) -> Unit)
}