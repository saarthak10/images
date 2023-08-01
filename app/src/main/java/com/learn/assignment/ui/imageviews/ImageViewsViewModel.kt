package com.learn.assignment.ui.imageviews

import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.learn.assignment.data.local.pref.PrefManager
import com.learn.assignment.data.model.ImagesListResponse
import com.learn.assignment.data.remote.APICallMethods
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ImageViewsViewModel @Inject constructor(sharePref:PrefManager,apiCallMethods: APICallMethods):ViewModel() {
    val imageList:MutableLiveData<MutableList<ImagesListResponse.Hit?>> = MutableLiveData();
    val imageItem:MutableLiveData<ImagesListResponse.Hit> = MutableLiveData()
    val position:MutableLiveData<Int> = MutableLiveData()

}