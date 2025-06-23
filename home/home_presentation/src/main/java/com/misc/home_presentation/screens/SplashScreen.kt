package com.misc.home_presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.misc.home_presentation.viewModel.HomeEvent
import com.misc.home_presentation.viewModel.HomeViewModel

@Composable
fun SplashScreen(viewModel: HomeViewModel = hiltViewModel()) {
    viewModel.onEvent(HomeEvent.OnRetrieveBeerList)
    Splash()
}

@Composable
fun Splash() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = com.misc.core.R.drawable.cerveza),
            contentDescription = "Beer List Logo",
            modifier = Modifier.size(200.dp)
        )
        Spacer(Modifier.size(20.dp))
        Text(
            text = stringResource(
                com.misc.core.R.string.app_welcome
            ), fontSize = 32.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily.SansSerif
        )
    }
}

@Composable
@Preview
fun SplashPreview() {
    Splash()
}