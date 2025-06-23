package com.misc.home_data.mapper

import com.misc.home_data.remote.BeerApi.Companion.BASE_URL
import com.misc.home_data.remote.BeerApi.Companion.IMAGES_URL
import com.misc.home_data.remote.dto.BeerDtoItem
import com.misc.core.model.DetailBeer
import java.time.YearMonth
import java.time.format.DateTimeFormatter
import java.util.Locale
import java.util.UUID
import kotlin.math.roundToInt

fun BeerDtoItem.toDetailBeer(): DetailBeer? {
    val ibu = ibu?.roundToInt() ?: 0
    val firstBrewed = firstBrewed.toMonthDateOrEmpty()
    val image = image?.toImageUrl() ?: ""
    return DetailBeer(
        id = id?.toString() ?: UUID.randomUUID().toString(),
        name = name ?: return null,
        tagline = tagline ?: "",
        description = description ?: "",
        image = image,
        firstBrewed = firstBrewed,
        ibu = ibu,
        foodPairing = foodPairing ?: emptyList()
    )
}

fun String?.toMonthDateOrEmpty(): String {
    return try {
        val formatter = DateTimeFormatter.ofPattern("MM/yyyy")
        val date = YearMonth.parse(this, formatter)
        val outputFormatter = DateTimeFormatter.ofPattern("MMMM yyyy", Locale("en"))
        date.format(outputFormatter)
    } catch (e: Exception) {
        ""
    }
}

fun String.toImageUrl(): String {
    return "$BASE_URL$IMAGES_URL$this"
}