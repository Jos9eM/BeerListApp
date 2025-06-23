package com.misc.home_presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import com.misc.core.model.DetailBeer
import com.misc.core.ui.IbuText
import com.misc.core.ui.SharedImage
import com.misc.home_presentation.viewModel.HomeEvent
import com.misc.home_presentation.viewModel.HomeViewModel

@Composable
fun HomeScreen(
    beerList: List<DetailBeer>, viewModel: HomeViewModel = hiltViewModel()
) {
    LazyColumn(Modifier.fillMaxSize()) {
        stickyHeader { Text("Beers") }
        items(items = beerList, key = { it.id }) {
            ListItem(
                modifier = Modifier.clickable {
                viewModel.onEvent(HomeEvent.OnBeerClick(it))
            },
                headlineContent = { Text(it.name) },
                supportingContent = { Text(it.tagline) },
                trailingContent = {
                    IbuText(
                        it.ibu.toString(), fontSize = 12, fontWeight = FontWeight.Normal
                    )
                },
                overlineContent = {
                    Text(
                        stringResource(
                            com.misc.core.R.string.beer_first_brewed,
                            it.firstBrewed
                        )
                    )
                },
                leadingContent = {
                    SharedImage(
                        imageUrl = it.image
                    )
                })
            HorizontalDivider()
        }
    }
}