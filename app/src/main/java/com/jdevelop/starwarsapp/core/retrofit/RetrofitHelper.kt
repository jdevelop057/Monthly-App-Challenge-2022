package com.jdevelop.starwarsapp.core.retrofit

/**
 * Created by Jdevelop057 on 09/02/2022.
 */
import com.jdevelop.starwarsapp.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.STAR_WARS_API)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}