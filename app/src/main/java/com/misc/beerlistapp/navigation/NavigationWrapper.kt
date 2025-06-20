package com.misc.beerlistapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.misc.beerlistapp.ui.splash.SplashScreen
import com.misc.core.navigation.Home
import com.misc.core.navigation.Splash
import com.misc.home_presentation.home.HomeScreen

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Splash) {
        composable<Splash> {
            SplashScreen{
                navController.navigate(Home)
            }
        }

        composable<Home> {
            HomeScreen()
        }
    }
}