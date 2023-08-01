package com.learn.assignment.ui.imageList

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.learn.assignment.data.local.pref.PrefManager
import com.learn.assignment.data.model.ImagesListResponse
import com.learn.assignment.data.remote.APICallMethods
import com.learn.assignment.repository.images.ImagesRepo
import com.learn.assignment.utils.CustomException
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class ImagesListViewModel @Inject constructor(private val prefManager: PrefManager,private val
apiCallMethods: APICallMethods,private  val imageRepo: ImagesRepo) :
    ViewModel() {

        //region variables
        val imageList:MutableLiveData<MutableList<ImagesListResponse.Hit?>> = MutableLiveData();
        //endregion



    //API Call Method
    fun getImageList(searchString:String,page:Int){
        imageRepo.getImageList(apiCallMethods,searchString=searchString,page=page, onSuccess = {
            Log.e(TAG, "getImageList: $it" )
            imageList.value  = it.hits
        }, onError = {

        })

    }

}