package com.jdevelop.starwarsapp.data.network.people

import com.jdevelop.starwarsapp.core.retrofit.RetrofitHelper
import com.jdevelop.starwarsapp.data.model.people.PeopleModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit

/**
 * Created by Jdevelop057 on 10/02/2022.
 */
class PeopleApiService {

    private val retrofit: Retrofit = RetrofitHelper.getRetrofit()

    suspend fun getPeople(): List<PeopleModel> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(PeopleApiClient::class.java).getAllPeople()
            response.body() ?: emptyList()
        }
    }
}