package com.packt.chaptersix.data

interface PetsRepository {
    suspend fun getPets(): NetworkResult<List<Cat>>
}