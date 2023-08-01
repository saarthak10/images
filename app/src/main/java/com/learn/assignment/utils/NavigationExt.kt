package com.learn.assignment.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.core.os.bundleOf
import com.learn.assignment.R
import com.learn.assignment.ui.imageList.ImagesListFragment
import com.learn.assignment.ui.imageviews.ImageViewsFragment
import com.learn.assignment.ui.main.MainActivity


fun Context.routeToMainActivityScreen(bundle: Bundle = bundleOf()) {
    val intent = Intent(this, MainActivity::class.java).apply {
        putExtras(bundle)
    }
    startActivity(intent)
}

/*----------------------------------------------------------------------------------------------*/


//Method to navigation Image List in fragment
fun Activity.navigateToImagesListScreen(bundle: Bundle = bundleOf()) {
    (this as MainActivity).executeNavigation(
        FragmentNavigationBuilder(ImagesListFragment())
            .container(mainContainer())
            .isAddFragment(true)
            .isBackStack(false)
            .bundle(bundle)
            .build()
    )

}
//Method to navigation Image View in fragment
fun Activity.navigateToImagesViewsScreen(bundle: Bundle = bundleOf()) {
    (this as MainActivity).executeNavigation(
        FragmentNavigationBuilder(ImageViewsFragment())
            .container(mainContainer())
            .isAddFragment(true)
            .isBackStack(true)
            .bundle(bundle)
            .build()
    )

}
/*----------------------------------------------------------------------------------------------*/
fun mainContainer(): Int = R.id.fcv_main_container

