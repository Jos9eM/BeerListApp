package com.misc.home_data.remote.dto


import com.google.gson.annotations.SerializedName

data class BeerDtoItem(
    @SerializedName("abv")
    val abv: Double?,
    @SerializedName("attenuation_level")
    val attenuationLevel: Double?,
    @SerializedName("boil_volume")
    val boilVolume: BoilVolume?,
    @SerializedName("brewers_tips")
    val brewersTips: String?,
    @SerializedName("contributed_by")
    val contributedBy: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("ebc")
    val ebc: Int?,
    @SerializedName("first_brewed")
    val firstBrewed: String?,
    @SerializedName("food_pairing")
    val foodPairing: List<String>?,
    @SerializedName("ibu")
    val ibu: Double?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("ingredients")
    val ingredients: Ingredients?,
    @SerializedName("method")
    val method: Method?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("ph")
    val ph: Double?,
    @SerializedName("srm")
    val srm: Double?,
    @SerializedName("tagline")
    val tagline: String?,
    @SerializedName("target_fg")
    val targetFg: Int?,
    @SerializedName("target_og")
    val targetOg: Double?,
    @SerializedName("volume")
    val volume: Volume?
)