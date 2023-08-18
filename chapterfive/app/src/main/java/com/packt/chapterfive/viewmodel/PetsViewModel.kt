package com.packt.chapterfive.viewmodel

import androidx.lifecycle.ViewModel
import com.packt.chapterfive.data.PetsRepository

class PetsViewModel(
    private val petsRepository: PetsRepository
): ViewModel() {

    fun getPets() = petsRepository.getPets()
}