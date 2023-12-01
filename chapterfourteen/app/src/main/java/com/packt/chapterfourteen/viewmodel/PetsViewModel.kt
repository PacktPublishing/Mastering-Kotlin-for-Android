package com.packt.chapterfourteen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.packt.chapterfourteen.data.Cat
import com.packt.chapterfourteen.data.NetworkResult
import com.packt.chapterfourteen.data.PetsRepository
import com.packt.chapterfourteen.data.asResult
import com.packt.chapterfourteen.views.PetsUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PetsViewModel(
    private val petsRepository: PetsRepository
) : ViewModel() {
    val petsUIState = MutableStateFlow(PetsUIState())
    private val _favoritePets = MutableStateFlow<List<Cat>>(emptyList())
    val favoritePets: StateFlow<List<Cat>> get() = _favoritePets

    init {
        getPets()
    }

    fun getPets() {
        petsUIState.value = PetsUIState(isLoading = true)
        viewModelScope.launch {
            petsRepository.getPets().asResult().collect { result ->
                when (result) {
                    is NetworkResult.Success -> {
                        petsUIState.update {
                            it.copy(isLoading = false, pets = result.data)
                        }
                    }

                    is NetworkResult.Error -> {
                        petsUIState.update {
                            it.copy(isLoading = false, error = result.error)
                        }
                    }
                }
            }
        }
    }

    fun updatePet(cat: Cat) {
        viewModelScope.launch {
            petsRepository.updatePet(cat)
        }
    }

    fun getFavoritePets() {
        viewModelScope.launch {
            petsRepository.getFavoritePets().collect {
                _favoritePets.value = it
            }
        }
    }
}
