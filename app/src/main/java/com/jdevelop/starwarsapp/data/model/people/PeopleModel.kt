package com.jdevelop.starwarsapp.data.model.people

import com.google.gson.annotations.SerializedName

/**
 * Created by Jdevelop057 on 10/02/2022.
 */

data class PeopleModel(
    @SerializedName("count") val count: Int,
    @SerializedName("next") val next: String?,
    @SerializedName("previous") val previous: String?,
    @SerializedName("results") val results: List<PeopleResultsModel>,
)
