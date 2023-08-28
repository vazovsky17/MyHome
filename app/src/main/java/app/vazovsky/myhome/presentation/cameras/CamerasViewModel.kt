package app.vazovsky.myhome.presentation.cameras

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import app.vazovsky.myhome.data.network.model.base.LoadableResult
import app.vazovsky.myhome.domain.model.CameraList
import app.vazovsky.myhome.domain.usecase.GetCamerasUseCase
import app.vazovsky.myhome.domain.usecase.base.UseCase
import app.vazovsky.myhome.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CamerasViewModel @Inject constructor(
    private val getCamerasUseCase: GetCamerasUseCase,
) : BaseViewModel() {

    /** Данные о камерах */
    private val _camerasLiveData = MutableLiveData<LoadableResult<CameraList>>()
    val camerasLiveData: LiveData<LoadableResult<CameraList>> = _camerasLiveData

    /** Получение камер */
    fun getCameras() {
        _camerasLiveData.launchLoadData(
            getCamerasUseCase.executeFlow(UseCase.None)
        )
    }
}