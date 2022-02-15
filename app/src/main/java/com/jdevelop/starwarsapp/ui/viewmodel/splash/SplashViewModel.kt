package com.jdevelop.starwarsapp.ui.viewmodel.splash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jdevelop.starwarsapp.data.model.people.PeopleModel
import com.jdevelop.starwarsapp.domain.usecases.people.GetAllPeople

/**
 * Created by Jdevelop057 on 08/02/2022.
 */
class SplashViewModel : ViewModel() {
    var splashViewModelGetData = MutableLiveData<PeopleModel>()
    val getAllPeople: GetAllPeople = GetAllPeople()


    suspend fun getData(page: Int): PeopleModel? = getAllPeople(page)

}