package com.packt.chaptersix.data

interface PetsRepository {
    fun getPets(): List<Pet>
}