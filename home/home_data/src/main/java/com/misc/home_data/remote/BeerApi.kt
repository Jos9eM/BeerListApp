package com.misc.home_data.remote

import com.misc.home_data.remote.dto.BeerDto
import retrofit2.http.GET
import retrofit2.http.POST

interface BeerApi {
    @GET("beers?page=1")
    suspend fun getBeers(): BeerDto

    companion object {
        const val BASE_URL = "https://punkapi.online/v3/"
        const val IMAGES_URL = "images/"
    }
}