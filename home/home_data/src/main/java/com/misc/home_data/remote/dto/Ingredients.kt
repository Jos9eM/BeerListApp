package com.misc.home_data.remote.dto


import com.google.gson.annotations.SerializedName

data class Ingredients(
    @SerializedName("hops")
    val hops: List<Hop>?,
    @SerializedName("malt")
    val malt: List<Malt>?,
    @SerializedName("yeast")
    val yeast: String?
)