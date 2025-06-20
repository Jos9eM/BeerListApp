package com.misc.home_presentation.home

sealed class HomeEvent {
    data object OnRetrieveBeers : HomeEvent()
    data object OnNavigateToDetail : HomeEvent()
}