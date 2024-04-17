package com.packt.chapterseven.data

interface PetsRepository {
    suspend fun getPets(): NetworkResult<List<Cat>>
}