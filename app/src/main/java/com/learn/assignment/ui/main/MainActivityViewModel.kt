package com.learn.assignment.ui.main

import androidx.lifecycle.ViewModel
import com.learn.assignment.data.local.pref.PrefManager
import com.learn.assignment.data.remote.APICallMethods
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainActivityViewModel @Inject constructor(private val prefManager: PrefManager) :
    ViewModel() {



}