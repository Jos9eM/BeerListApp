package com.misc.core.model

import androidx.compose.runtime.Immutable
import kotlinx.serialization.Serializable

@Serializable
@Immutable
class DetailBeer(
    val id: String,
    val name: String,
    val tagline: String,
    val description: String,
    val image: String,
    val firstBrewed: String,
    val ibu: Int,
    val foodPairing: List<String>
)

@Serializable
@Immutable
class ListBeer(
    val beers: List<DetailBeer>
)