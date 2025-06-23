package com.misc.home_domain.repository

import com.misc.core.model.DetailBeer

interface HomeRepository {
    suspend fun retrieveBeers(): Result<List<DetailBeer>>
}