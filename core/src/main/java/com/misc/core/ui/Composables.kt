package com.misc.core.ui

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import com.misc.core.R
import com.misc.core.util.ibuColor

@Composable
fun SharedImage(
    imageUrl: String, size: Int = 40
) {
    val context = LocalContext.current

    AsyncImage(
        model = ImageRequest.Builder(context).data(imageUrl).crossfade(true)
            .diskCachePolicy(CachePolicy.ENABLED).memoryCachePolicy(CachePolicy.ENABLED)
            .placeholder(R.drawable.cerveza).error(R.drawable.cerveza).build(),
        contentDescription = "Beer_Image",
        modifier = Modifier.size(size.dp),
        contentScale = ContentScale.Fit,
    )
}

@Composable
fun IbuText(ibuString: String, fontWeight: FontWeight = FontWeight.Bold, fontSize: Int = 16) {
    val ibuValue = ibuString.toIntOrNull() ?: 0

    val text = buildAnnotatedString {
        append(stringResource(R.string.beer_ibu))
        append(" ")
        withStyle(style = SpanStyle(color = ibuColor(ibuValue), fontWeight = fontWeight)) {
            append(ibuString)
        }
    }
    Text(
        text = text, fontSize = fontSize.sp
    )
}