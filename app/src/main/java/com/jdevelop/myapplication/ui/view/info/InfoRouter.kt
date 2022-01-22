package com.jdevelop.myapplication.ui.view.info

import android.content.Context
import android.content.Intent
import com.jdevelop.myapplication.ui.base.BaseActivityRouter

/**
 * Created by Jdevelop057 on 22/01/2022.
 */
class InfoRouter: BaseActivityRouter {
    override fun intent(activity: Context): Intent = Intent(activity, InfoActivity::class.java)
}