package com.misc.home_presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.misc.home_domain.use_cases.HomeUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeUseCases: HomeUseCases) : ViewModel() {
    var state by mutableStateOf(HomeState())
        private set

    public fun retrieveBeers() {
        viewModelScope.launch {
            homeUseCases.getBeers()
        }
    }

}