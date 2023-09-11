package com.packt.chaptereight.data

interface PetsRepository {
    suspend fun getPets(): NetworkResult<List<Cat>>
}