package app.vazovsky.myhome.presentation.cameras

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import app.vazovsky.myhome.R
import app.vazovsky.myhome.domain.model.Camera
import app.vazovsky.myhome.domain.model.CameraRoom
import app.vazovsky.myhome.presentation.common.EmptyUI
import app.vazovsky.myhome.presentation.common.ErrorUI
import app.vazovsky.myhome.presentation.common.FakeVideoUI
import app.vazovsky.myhome.presentation.common.LoadImageFromUrl
import app.vazovsky.myhome.presentation.common.LoadingUI
import app.vazovsky.myhome.presentation.common.MyHomeCard

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
            CamerasDataUI(
                rooms = data.rooms,
                onRetry = { viewModel.getCameras() },
                onFavoriteClick = {},
            )
        }
        camerasState?.doOnFailure {
            ErrorUI(it) { viewModel.getCameras() }
        }
        camerasState?.doOnLoading {
            LoadingUI()
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CamerasDataUI(rooms: List<CameraRoom>, onRetry: () -> Unit, onFavoriteClick: () -> Unit) {
    val listState = rememberLazyListState()

    if (rooms.isNotEmpty()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            state = listState,
            contentPadding = PaddingValues(21.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            rooms.forEach { room ->
                stickyHeader {
                    Text(
                        modifier = Modifier.padding(end = 16.dp),
                        text = room.name,
                        fontWeight = FontWeight.Light,
                        color = Color.Black,
                        fontSize = 30.sp,
                    )
                }
                items(room.cameras) { camera ->
                    CameraUI(camera) { onFavoriteClick() }
                }
            }
        }
    } else {
        EmptyUI { onRetry() }
    }
}

@Composable
fun CameraUI(camera: Camera, onFavoriteClick: () -> Unit) {
    MyHomeCard(title = camera.name) {
        camera.snapshotUrl?.let { url ->
            FakeVideoUI(url = url, isFavorite = camera.isFavorite, isRec = camera.isRecording)
        }
    }
}
