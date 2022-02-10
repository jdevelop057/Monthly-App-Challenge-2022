package com.jdevelop.starwarsapp.data.model.people

import com.google.gson.annotations.SerializedName

/**
 * Created by Jdevelop057 on 10/02/2022.
 */

data class PeopleResultsModel(
    @SerializedName("name") val name: String,
    @SerializedName("height") val height: String,
    @SerializedName("mass") val mass: String,
    @SerializedName("hair_color") val hair_color: String,
    @SerializedName("skin_color") val skin_color: String,
    @SerializedName("eye_color") val eye_color: String,
    @SerializedName("birth_year") val birth_year: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("homeworld") val homeworld: String,
    @SerializedName("films") val films: String,
    @SerializedName("species") val species: String,
    @SerializedName("vehicles") val vehicles: String,
    @SerializedName("starships") val starships: String,
    @SerializedName("url") val url: String
)