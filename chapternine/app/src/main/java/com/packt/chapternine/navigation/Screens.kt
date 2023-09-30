package com.packt.chapternine.navigation

sealed class Screens(val route: String) {
    object PetsScreen : Screens("pets")
    object PetDetailsScreen : Screens("petDetails")
    object FavoritePetsScreen : Screens("favoritePets")
}