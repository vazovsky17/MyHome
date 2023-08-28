package app.vazovsky.myhome.presentation.cameras

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import app.vazovsky.myhome.domain.model.CameraList
import app.vazovsky.myhome.presentation.common.ErrorUI
import app.vazovsky.myhome.presentation.common.LoadingUI

@Composable
fun CamerasScreen(
    viewModel: CamerasViewModel = hiltViewModel()
) {
    val camerasState by viewModel.camerasLiveData.observeAsState()

    LaunchedEffect(true) {
        viewModel.getCameras()
    }
    Box(modifier = Modifier.fillMaxSize()) {
        camerasState?.doOnSuccess { data ->
            CamerasDataUI(data)
        }
        camerasState?.doOnFailure {
            ErrorUI(it) { viewModel.getCameras() }
        }
        camerasState?.doOnLoading {
            LoadingUI()
        }
    }
}

@Composable
fun CamerasDataUI(data: CameraList) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Тут будут данные",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp
        )
    }
}
