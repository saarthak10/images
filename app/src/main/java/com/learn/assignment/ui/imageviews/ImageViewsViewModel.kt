package com.learn.assignment.ui.imageviews

import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.learn.assignment.data.local.pref.PrefManager
import com.learn.assignment.data.remote.APICallMethods
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ImageViewsViewModel @Inject constructor(sharePref:PrefManager,apiCallMethods: APICallMethods):ViewModel() {
    var imageList:MutableLiveData<MutableList<String>> = MutableLiveData(mutableListOf("https://pixabay.com/get/g7c06fa5b77fd79096873c8e710f70688a39d04ffc1363860c6eb53b50d19dc80ff1fc4bffb4f3604f9153f7397fbe107_640.jpg",
        "https://pixabay.com/get/gba406b4a6b87e313a618e659985473db594a58c04c6c139fb3bc10576469fa08824125d7b262b0b576ba774fea8d3b7f172ea63c1a72766102faca0802402afd_640.jpg",
        "https://pixabay.com/get/g913c8e670dd41afec7f2eec0eaf22a93c3306db372f9470e22c3be9d529fa4b733d3e0fd74b7daf9913f0808bbd98876_640.jpg"))

}