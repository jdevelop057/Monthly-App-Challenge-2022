package com.jdevelop.starwarsapp.domain.usecases.people

import com.jdevelop.starwarsapp.data.model.people.PeopleModel
import com.jdevelop.starwarsapp.data.repositories.people.PeopleRepository

/**
 * Created by Jdevelop057 on 10/02/2022.
 */
class GetAllPeople {

    private val repository: PeopleRepository = PeopleRepository()

    suspend operator fun invoke(): List<PeopleModel> =
        repository.getAllPeople()
}