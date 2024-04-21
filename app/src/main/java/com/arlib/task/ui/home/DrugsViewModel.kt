package com.arlib.task.ui.home


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arlib.task.domain.models.Drug
import com.arlib.task.domain.usecase.GetDrugsUseCase
import com.arlib.task.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DrugsViewModel @Inject constructor(
    private val getDrugsUseCase: GetDrugsUseCase
) : ViewModel() {

    var drug: Drug? = Drug(name = "name")

    init {
        getDrugs()
    }

    private val _drugs =
        MutableStateFlow<Resource<List<Drug>>>(Resource.Loading)
    val drugsFlow: Flow<Resource<List<Drug>>> = _drugs

    fun getDrugs() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val drugs = getDrugsUseCase()
                _drugs.value = Resource.Success(drugs.first())
            } catch (e: Exception) {
                _drugs.value = Resource.Error(e)
            }
        }
    }

}