package com.misc.home_presentation.home

import com.misc.home_domain.model.DetailBeer

data class HomeState(
    val isLoading: Boolean = false,
    val trackableFood: List<DetailBeer> = emptyList()
)
