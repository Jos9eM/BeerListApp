package com.misc.home_presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.misc.core.model.DetailBeer
import com.misc.core.ui.IbuText
import com.misc.core.ui.SharedImage

@Composable
fun DetailScreen(
    beer: DetailBeer
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SharedImage(imageUrl = beer.image, size = 200)
        Text(beer.name, fontSize = 32.sp, fontWeight = FontWeight.Bold)
        Text(beer.tagline, fontSize = 24.sp, textDecoration = TextDecoration.Underline)
        Text(
            beer.description, fontSize = 18.sp, textAlign = TextAlign.Justify
        )
        Text(text = stringResource(com.misc.core.R.string.beer_first_brewed, beer.firstBrewed))
        IbuText(ibuString = beer.ibu.toString())
        Column(
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = stringResource(com.misc.core.R.string.beer_food_pairing, beer.firstBrewed),
                textDecoration = TextDecoration.Underline
            )
            beer.foodPairing.forEach {
                Row(
                    modifier = Modifier.padding(vertical = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "•")
                    Spacer(modifier = Modifier.size(4.dp))
                    Text(text = it)
                }
            }
        }
        Spacer(modifier = Modifier.size(20.dp))
    }
}