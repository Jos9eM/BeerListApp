package com.misc.home_domain.use_cases

import com.misc.home_domain.model.DetailBeer
import com.misc.home_domain.repository.HomeRepository

class RetrieveBeers(private val repository: HomeRepository) {
    suspend operator fun invoke(): Result<List<DetailBeer>> {
        return repository.retrieveBeers()
    }
}