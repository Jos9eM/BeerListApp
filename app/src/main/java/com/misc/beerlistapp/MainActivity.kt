package com.misc.beerlistapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.misc.beerlistapp.ui.theme.BeerListAppTheme
import com.misc.core.model.DetailBeer
import com.misc.core.model.ListBeer
import com.misc.core.navigation.Destination
import com.misc.core.navigation.NavigationAction
import com.misc.core.navigation.Navigator
import com.misc.core.ui.ObserveAsEvents
import com.misc.core.util.serializableNavType
import com.misc.home_presentation.screens.DetailScreen
import com.misc.home_presentation.screens.ErrorScreen
import com.misc.home_presentation.screens.HomeScreen
import com.misc.home_presentation.screens.SplashScreen
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlin.reflect.typeOf

@AndroidEntryPoint
@OptIn(ExperimentalSharedTransitionApi::class)
@SuppressLint("UnusedSharedTransitionModifierParameter")
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BeerListAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()

                    ObserveAsEvents(flow = navigator.navigationAction) { action ->
                        when (action) {
                            is NavigationAction.NavigateTo -> {
                                navController.navigate(
                                    action.destination
                                ) {
                                    action.navOptions(this)
                                }
                            }

                            NavigationAction.NavigateUp -> navController.navigateUp()
                            NavigationAction.PopBackStack -> navController.popBackStack()
                        }
                    }

                    NavHost(
                        navController = navController,
                        startDestination = navigator.startDestination,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable<Destination.Splash> {
                            SplashScreen()
                        }

                        composable<Destination.Home>(
                            typeMap = mapOf(
                                typeOf<ListBeer>() to serializableNavType<ListBeer>(),
                            )
                        ) { backStackEntry ->
                            val args = backStackEntry.toRoute<Destination.Home>()
                            HomeScreen(
                                beerList = args.beerList.beers
                            )
                        }

                        composable<Destination.Detail>(
                            typeMap = mapOf(
                                typeOf<DetailBeer>() to serializableNavType<DetailBeer>(),
                            )
                        ) { backStackEntry ->
                            val args = backStackEntry.toRoute<Destination.Detail>()
                            DetailScreen(beer = args.beer)
                        }

                        composable<Destination.Error> {
                            ErrorScreen()
                        }
                    }
                }
            }
        }
    }
}