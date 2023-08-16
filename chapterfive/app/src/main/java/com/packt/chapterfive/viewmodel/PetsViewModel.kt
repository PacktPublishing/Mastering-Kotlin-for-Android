package com.packt.chapterfive.viewmodel

import androidx.lifecycle.ViewModel
import com.packt.chapterfive.data.PetsRepository
import com.packt.chapterfive.data.PetsRepositoryImpl

class PetsViewModel: ViewModel() {
    private val petsRepository: PetsRepository = PetsRepositoryImpl()

    fun getPets() = petsRepository.getPets()
}