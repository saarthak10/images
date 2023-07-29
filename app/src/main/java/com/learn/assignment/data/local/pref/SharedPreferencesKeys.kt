package com.learn.assignment.data.local.pref

/**
 * Shared preferences keys
 *
 * @constructor Create empty Shared preferences keys
 */
interface SharedPreferencesKeys {
    companion object {
        const val PRIVATE_MODE = 0
        const val SHAREPRE_NAME = "ImagesSearch"
        const val ACCESS_TOKEN = "accessToken"
        const val USER_PROFILE = "userProfile"
    }
}