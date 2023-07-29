package com.learn.assignment.data.local.pref

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.learn.assignment.data.local.pref.SharedPreferencesKeys.Companion.SHAREPRE_NAME
import javax.inject.Inject


class PrefManager
@Inject constructor() : SharedPreferencesKeys {
    var pref: SharedPreferences? = null


    /**
     * init shared preference
     * @param context application context
     */

    fun initPref(context: Context): PrefManager {
        pref = context.getSharedPreferences(SHAREPRE_NAME, MODE_PRIVATE)
        return this
    }


}