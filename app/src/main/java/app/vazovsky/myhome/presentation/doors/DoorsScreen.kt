package app.vazovsky.myhome.presentation.doors

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import app.vazovsky.myhome.R
import app.vazovsky.myhome.domain.model.Door
import app.vazovsky.myhome.domain.model.DoorRoom
import app.vazovsky.myhome.presentation.common.EmptyUI
import app.vazovsky.myhome.presentation.common.ErrorUI
import app.vazovsky.myhome.presentation.common.FakeVideoUI
import app.vazovsky.myhome.presentation.common.LoadingUI
import app.vazovsky.myhome.presentation.common.MyHomeCard

@Composable
fun DoorsScreen(
    viewModel: DoorsViewModel = hiltViewModel()
) {
    val doorsState by viewModel.doorsLiveData.observeAsState()

    LaunchedEffect(true) {
        viewModel.getDoors()
    }
    Box(modifier = Modifier.fillMaxSize()) {
        doorsState?.doOnSuccess { data ->
            DoorsDataUI(
                rooms = data.rooms,
                onRetry = { viewModel.getDoors() },
                onFavoriteClick = {},
            )
        }
        doorsState?.doOnFailure {
            ErrorUI(it) { viewModel.getDoors() }
        }
        doorsState?.doOnLoading {
            LoadingUI()
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DoorsDataUI(rooms: List<DoorRoom>, onRetry: () -> Unit, onFavoriteClick: () -> Unit) {
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
                items(room.doors) { door ->
                    DoorUI(door) { onFavoriteClick() }
                }
            }
        }
    } else {
        EmptyUI { onRetry() }
    }
}

@Composable
fun DoorUI(door: Door, onFavoriteClick: () -> Unit) {
    MyHomeCard(title = door.name, comment = door.snapshotUrl?.let { stringResource(R.string.default_door_comment) }) {
        door.snapshotUrl?.let { url ->
            FakeVideoUI(url = url, isFavorite = door.isFavorite, isRec = false)
        }
    }
}
