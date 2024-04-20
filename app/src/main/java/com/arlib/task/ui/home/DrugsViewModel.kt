package com.arlib.task.ui.home


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arlib.task.domain.models.DrugsResponse
import com.arlib.task.domain.usecase.GetDrugsUseCase
import com.arlib.task.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DrugsViewModel @Inject constructor(
    private val getDrugsUseCase: GetDrugsUseCase
) : ViewModel() {

    init {
        getDrugs()
    }

    private val _drugs = MutableStateFlow<Resource<DrugsResponse>>(Resource.Idle)
    val drugsFlow: Flow<Resource<DrugsResponse>> = _drugs

    fun getDrugs() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _drugs.emit(
                    Resource.Success(
                        getDrugsUseCase.invoke()
                    )
                )
            } catch (e: Exception) {
                _drugs.emit(
                    Resource.Error(e)
                )
            }
        }
    }

}