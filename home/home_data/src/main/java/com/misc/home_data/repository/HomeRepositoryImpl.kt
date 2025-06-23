package com.misc.home_data.repository

import com.misc.home_data.mapper.toDetailBeer
import com.misc.home_data.remote.BeerApi
import com.misc.core.model.DetailBeer
import com.misc.home_domain.repository.HomeRepository

class HomeRepositoryImpl(
    private val api: BeerApi
) : HomeRepository {
    override suspend fun retrieveBeers(): Result<List<DetailBeer>> {
        return try {
            val beerDto = api.getBeers()
            Result.success(beerDto.mapNotNull { it.toDetailBeer() })
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}