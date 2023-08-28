package app.vazovsky.myhome.presentation.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import app.vazovsky.myhome.R

@Composable
fun FakeVideoUI(
    url: String,
    isFavorite: Boolean,
    heightBlock: Dp = 207.dp,
    alpha: Float = 0.5F,
    isRec: Boolean,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(heightBlock),
    ) {
        LoadImageFromUrl(url = url, alpha = alpha)

        IconButton(
            modifier = Modifier.align(Alignment.Center),
            onClick = {},
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_play_button),
                contentDescription = null,
                tint = Color.White,
            )
        }
        if (isFavorite) {
            Icon(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 4.dp, end = 4.dp),
                painter = painterResource(id = R.drawable.ic_star_on),
                tint = Color.Yellow,
                contentDescription = null,
            )
        }
    }
}