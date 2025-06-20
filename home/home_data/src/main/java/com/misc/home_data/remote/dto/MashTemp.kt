package com.misc.home_data.remote.dto


import com.google.gson.annotations.SerializedName

data class MashTemp(
    @SerializedName("duration")
    val duration: Int?,
    @SerializedName("temp")
    val temp: Temp?
)