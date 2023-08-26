package app.vazovsky.myhome.data.repository

import app.vazovsky.myhome.domain.model.CameraList

interface CameraRepository {
    suspend fun getCameras(): CameraList
}