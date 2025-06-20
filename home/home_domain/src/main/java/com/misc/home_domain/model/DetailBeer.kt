package com.misc.home_domain.model

class DetailBeer(
    val name: String,
    val tagline: String,
    val description: String,
    val image: String,
    val firstBrewed: String,
    val ibu: Int,
    val foodPairing: List<String>
)