package com.jdevelop.myapplication.ui.base

import android.content.Context
import android.content.Intent

/**
 * Created by Jdevelop057 on 21/01/2022.
 */


interface BaseActivityRouter {
    fun intent(activity: Context): Intent
    fun launch(activity: Context) = activity.startActivity(intent(activity))
}