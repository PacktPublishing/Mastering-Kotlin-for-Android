package com.packt.chapterseven.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.packt.chapterseven.views.PetDetailsScreen
import com.packt.chapterseven.views.PetsScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination =  Screens.PetsScreen.route
    ){
        composable(Screens.PetsScreen.route){
            PetsScreen(
                onPetClicked = {
                    navController.navigate(Screens.PetDetailsScreen.route)
                }
            )
        }

        composable(Screens.PetDetailsScreen.route){
            PetDetailsScreen(
                onBackPressed = {
                    navController.popBackStack()
                }
            )
        }
    }
}