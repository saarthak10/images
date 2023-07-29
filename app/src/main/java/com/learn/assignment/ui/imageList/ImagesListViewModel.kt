package com.learn.assignment.ui.imageList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.learn.assignment.data.local.pref.PrefManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class ImagesListViewModel @Inject constructor(private val prefManager: PrefManager) :
    ViewModel() {

        //region variables
          val searchString = MutableLiveData<String>()
        //endregion

    //region init
    init {
        searchString.value = ""
    }
    //endregion
}