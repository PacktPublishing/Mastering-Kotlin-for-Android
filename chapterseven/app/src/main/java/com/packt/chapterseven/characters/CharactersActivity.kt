package com.packt.chapterseven.characters

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
class CharactersActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            when(calculateWindowSizeClass(activity = this).widthSizeClass) {
                WindowWidthSizeClass.Compact -> {
                    CharactersScreen(
                        navigationOptions = NavigationOptions.BottomNavigation,
                        showDetails = false
                    )
                }
                WindowWidthSizeClass.Medium -> {
                    CharactersScreen(
                        navigationOptions = NavigationOptions.NavigationRail,
                        showDetails = true
                    )
                }
                WindowWidthSizeClass.Expanded -> {
                    CharactersScreen(
                        navigationOptions = NavigationOptions.NavigationDrawer,
                        showDetails = true
                    )
                }
                else -> {
                    CharactersScreen(
                        navigationOptions = NavigationOptions.BottomNavigation,
                        showDetails = false
                    )
                }
            }

        }
    }
}