package com.misc.core.navigation

import com.misc.core.model.DetailBeer
import com.misc.core.model.ListBeer
import kotlinx.serialization.Serializable

sealed interface Destination {
    @Serializable
    data object Splash : Destination

    @Serializable
    data class Home(val beerList: ListBeer = ListBeer(emptyList())) : Destination

    @Serializable
    data class Detail(val beer: DetailBeer) : Destination

    @Serializable
    data object Error : Destination
}