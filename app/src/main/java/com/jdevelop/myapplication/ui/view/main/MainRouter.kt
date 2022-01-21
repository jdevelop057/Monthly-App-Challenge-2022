package com.jdevelop.myapplication.ui.view.main

import android.content.Context
import android.content.Intent
import com.jdevelop.myapplication.ui.base.BaseActivityRouter

/**
 * Created by Jdevelop057 on 21/01/2022.
 */
class MainRouter: BaseActivityRouter {
    override fun intent(activity: Context): Intent = Intent(activity, MainActivity::class.java)
}