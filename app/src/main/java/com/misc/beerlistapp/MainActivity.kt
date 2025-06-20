package com.misc.beerlistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.misc.beerlistapp.navigation.NavigationWrapper
import com.misc.beerlistapp.ui.theme.BeerListAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BeerListAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
                    NavigationWrapper()
                }
            }
        }
    }
}