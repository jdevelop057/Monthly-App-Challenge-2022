package com.jdevelop.starwarsapp.ui.view.detail

import android.content.Context
import android.content.Intent
import com.google.gson.Gson
import com.jdevelop.starwarsapp.core.router.BaseActivityRouter
import com.jdevelop.starwarsapp.data.model.people.PeopleResultsModel


/**
 * Created by Jdevelop057 on 15/02/2022.
 */
class DetailRouter : BaseActivityRouter {

    private val RESULTS = "RESULTS"

    override fun intent(activity: Context): Intent = Intent(activity, DetailActivity::class.java)

    fun intent(activity: Context, peopleResultsModel: PeopleResultsModel): Intent {
        val intent = intent(activity)
        val gson = Gson()
        val peopleResultsModelGson = gson.toJson(peopleResultsModel)
        intent.putExtra(RESULTS, peopleResultsModelGson)
        return intent
    }

    fun launch(activity: Context, peopleResultsModel: PeopleResultsModel) {
        activity.startActivity(intent(activity, peopleResultsModel))
    }

}