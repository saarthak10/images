package com.learn.assignment.di

import android.content.Context
import com.learn.assignment.data.local.pref.PrefManager
import com.learn.assignment.data.remote.APICallMethods
import com.learn.assignment.data.remote.APIHandler
import com.learn.assignment.repository.images.ImagesRepo
import com.learn.assignment.repository.images.ImagesRepoImpl
import com.learn.assignment.ui.imageviews.ImageViewsViewModel
import com.learn.assignment.ui.imageList.ImagesListViewModel
import com.learn.assignment.ui.main.MainActivityViewModel
import com.learn.assignment.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun getApiHandler(): APICallMethods {
        return APIHandler(Constants.BASE_URL).handler
    }

    @Provides
    @Singleton
    fun getPrefManager(@ApplicationContext context: Context): PrefManager {
        return PrefManager().initPref(context.applicationContext)
    }

    @Provides
    @Singleton
    fun getMainActivityViewModel( prefManager: PrefManager): MainActivityViewModel{
        return MainActivityViewModel(prefManager)
    }

    @Provides
    @Singleton
    fun getImagesRepo(): ImagesRepo {
        return ImagesRepoImpl()
    }
    @Provides
    @Singleton
    fun getImageViewsViewModel( prefManager: PrefManager,apiCallMethods: APICallMethods): ImageViewsViewModel {
        return ImageViewsViewModel(prefManager, apiCallMethods)
    }
    @Provides
    @Singleton
    fun getImagesListViewModel( prefManager: PrefManager,apiCallMethods: APICallMethods,
                                imageRepo:ImagesRepo):
            ImagesListViewModel {
        return ImagesListViewModel(prefManager,apiCallMethods,imageRepo)
    }


}