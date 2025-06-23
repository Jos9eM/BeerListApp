package com.misc.home_presentation.viewModel

import com.misc.core.model.DetailBeer

sealed class HomeEvent {
    data object OnRetrieveBeerList : HomeEvent()
    data object OnNavigateToError : HomeEvent()
    data class OnBeerClick(val beer: DetailBeer) : HomeEvent()
}