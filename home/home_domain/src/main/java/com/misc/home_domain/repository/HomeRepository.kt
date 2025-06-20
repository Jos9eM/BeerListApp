package com.misc.home_domain.repository

import com.misc.home_domain.model.DetailBeer

interface HomeRepository {
    suspend fun retrieveBeers(): Result<List<DetailBeer>>
}