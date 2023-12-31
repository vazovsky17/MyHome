package app.vazovsky.myhome.presentation.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import app.vazovsky.myhome.R

@Composable
fun ErrorUI(error: String?, onRetry: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = error ?: stringResource(R.string.error_something_wrong),
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp
        )
        Button(
            onClick = { onRetry() }
        ) {
            Text(text = stringResource(R.string.error_update))
        }
    }
}