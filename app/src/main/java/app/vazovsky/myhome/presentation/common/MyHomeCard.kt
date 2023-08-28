package app.vazovsky.myhome.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun MyHomeCard(
    title: String,
    comment: String? = null,
    heightTextBlock: Dp = 72.dp,
    background: Color = Color.White,
    cornerRadius: Dp = 12.dp,
    content: @Composable() (() -> Unit?)? = null,
) {
    Card(
        shape = RoundedCornerShape(cornerRadius),
    ) {
        Column {
            if (content != null) {
                content()
            }
            Row(
                Modifier
                    .height(heightTextBlock)
                    .fillMaxWidth()
                    .background(background),
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                ) {
                    Text(
                        modifier = Modifier.padding(start = 16.dp),
                        text = title,
                    )
                    comment?.let {
                        Text(
                            modifier = Modifier.padding(start = 16.dp),
                            text = comment,
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun MyHomeCartPreview() {
    MyHomeCard(title = "Камера 1", comment = "В сети")
}