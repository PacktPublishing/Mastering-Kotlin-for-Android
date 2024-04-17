package com.packt.chapterfive.data

interface PetsRepository {
    fun getPets(): List<Pet>
}