package com.misc.core.navigation

import androidx.navigation.NavOptionsBuilder

sealed interface NavigationAction {
    data class NavigateTo(
        val destination: Destination, val navOptions: NavOptionsBuilder.() -> Unit = {}
    ) : NavigationAction

    data object NavigateUp : NavigationAction

    data object PopBackStack : NavigationAction
}