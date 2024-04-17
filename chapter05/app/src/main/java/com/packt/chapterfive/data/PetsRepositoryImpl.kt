package com.packt.chapterfive.data

class PetsRepositoryImpl: PetsRepository {
    override fun getPets(): List<Pet> {
        return listOf(
            Pet(1, "Bella", "Dog"),
            Pet(2, "Luna", "Cat"),
            Pet(3, "Charlie", "Dog"),
            Pet(4, "Lucy", "Cat"),
            Pet(5, "Cooper", "Dog"),
            Pet(6, "Max", "Cat"),
            Pet(7, "Bailey", "Dog"),
            Pet(8, "Daisy", "Cat"),
            Pet(9, "Sadie", "Dog"),
            Pet(10, "Lily", "Cat"),
        )
    }
}