package com.jdevelop.starwarsapp.data.repositories.people

import com.jdevelop.starwarsapp.data.model.people.PeopleModel
import com.jdevelop.starwarsapp.data.network.people.PeopleApiService

/**
 * Created by Jdevelop057 on 10/02/2022.
 */
class PeopleRepository {

    private val api = PeopleApiService()

    suspend fun getAllPeople(page: Int): PeopleModel? = api.getPeople(page)
}