package com.packt.chaptersix.viewmodel

import androidx.lifecycle.ViewModel
import com.packt.chaptersix.data.PetsRepository

class PetsViewModel(
    private val petsRepository: PetsRepository
): ViewModel() {

    fun getPets() = petsRepository.getPets()
}