package com.jdevelop.starwarsapp.data.network.people

import com.jdevelop.starwarsapp.data.model.people.PeopleModel
import com.jdevelop.starwarsapp.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Jdevelop057 on 10/02/2022.
 */
interface PeopleApiClient {
    @GET(Constants.STAR_WARS_API_PEOPLE)
    suspend fun getAllPeople(
        @Query("page") page: Int
    ): Response<PeopleModel>
}