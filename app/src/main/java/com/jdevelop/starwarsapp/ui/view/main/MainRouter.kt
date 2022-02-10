package com.jdevelop.starwarsapp.ui.view.main

import android.content.Context
import android.content.Intent
import com.jdevelop.starwarsapp.core.router.BaseActivityRouter

/**
 * Created by Jdevelop057 on 10/02/2022.
 */
class MainRouter: BaseActivityRouter {
    override fun intent(activity: Context): Intent = Intent(activity, MainActivity::class.java)
}