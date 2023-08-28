package app.vazovsky.myhome.presentation.doors

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import app.vazovsky.myhome.data.network.model.base.LoadableResult
import app.vazovsky.myhome.domain.model.DoorList
import app.vazovsky.myhome.domain.usecase.GetDoorsUseCase
import app.vazovsky.myhome.domain.usecase.base.UseCase
import app.vazovsky.myhome.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DoorsViewModel @Inject constructor(
    private val getDoorsUseCase: GetDoorsUseCase,
) : BaseViewModel() {

    /** Данные о дверях */
    private val _doorsLiveData = MutableLiveData<LoadableResult<DoorList>>()
    val doorsLiveData: LiveData<LoadableResult<DoorList>> = _doorsLiveData

    /** Получение дверей */
    fun getDoors() {
        _doorsLiveData.launchLoadData(
            getDoorsUseCase.executeFlow(UseCase.None)
        )
    }
}