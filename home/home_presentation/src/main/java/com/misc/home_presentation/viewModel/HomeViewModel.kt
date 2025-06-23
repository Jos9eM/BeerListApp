package com.misc.home_presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.misc.core.model.ListBeer
import com.misc.core.navigation.Destination
import com.misc.core.navigation.Navigator
import com.misc.home_domain.use_cases.HomeUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val navigator: Navigator, private val homeUseCases: HomeUseCases
) : ViewModel() {

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.OnRetrieveBeerList -> {
                retrieveBeers()
            }

            is HomeEvent.OnNavigateToError -> {
                viewModelScope.launch {
                    navigator.navigate(destination = Destination.Error)
                }
            }

            is HomeEvent.OnBeerClick -> {
                viewModelScope.launch {
                    navigator.navigate(destination = Destination.Detail(event.beer))
                }
            }
        }
    }

    private fun retrieveBeers() {
        viewModelScope.launch {
            homeUseCases.getBeers().onFailure {
                navigator.navigate(destination = Destination.Error)
            }.onSuccess { list ->
                if (list.isEmpty()) {
                    navigator.navigate(destination = Destination.Error)
                } else {
                    navigator.popBackStack()
                    navigator.navigate(destination = Destination.Home(ListBeer(list)))
                }
            }
        }
    }
}