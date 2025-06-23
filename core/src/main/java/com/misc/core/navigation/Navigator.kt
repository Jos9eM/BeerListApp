package com.misc.core.navigation

import androidx.navigation.NavOptionsBuilder
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow

interface Navigator {
    val startDestination: Destination
    val navigationAction: Flow<NavigationAction>

    suspend fun navigate(destination: Destination, navOptions: NavOptionsBuilder.() -> Unit = {})
    suspend fun navigateUp()
    suspend fun popBackStack()
}

class DefaultNavigator(
    override val startDestination: Destination,
) : Navigator {
    private val _navigationAction = Channel<NavigationAction>()
    override val navigationAction = _navigationAction.receiveAsFlow()
    override suspend fun navigate(
        destination: Destination, navOptions: NavOptionsBuilder.() -> Unit
    ) {
        _navigationAction.send(NavigationAction.NavigateTo(destination, navOptions))
    }

    override suspend fun navigateUp() {
        _navigationAction.send(NavigationAction.NavigateUp)
    }

    override suspend fun popBackStack() {
        _navigationAction.send(NavigationAction.PopBackStack)
    }
}