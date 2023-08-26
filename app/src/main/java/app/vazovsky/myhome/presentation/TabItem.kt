package app.vazovsky.myhome.presentation

import app.vazovsky.myhome.R
import app.vazovsky.myhome.presentation.cameras.CamerasScreen
import app.vazovsky.myhome.presentation.doors.DoorsScreen
import app.vazovsky.myhome.presentation.ui.ComposableScreen

sealed class TabItem(val title: Int, val screen: ComposableScreen) {
    object Cameras : TabItem(R.string.tab_cameras_label, { CamerasScreen() })
    object Doors : TabItem(R.string.tab_doors_label, { DoorsScreen() })
}