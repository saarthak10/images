package com.learn.assignment.base

import android.app.Application
import com.learn.assignment.utils.InternetUtil
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AssignmentApplication : Application() {


    override fun onCreate() {
        super.onCreate()
        //init internet utils
        InternetUtil.init(this)
    }
}