package com.packt.chapterseven.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.packt.chapterseven.views.PetsBottomNavigationBar
import com.packt.chapterseven.views.PetsNavigationRail

@Composable
fun AppNavigationContent(
    contentType: ContentType,
    navigationType: NavigationType,
    onFavoriteClicked: () -> Unit,
    onHomeClicked: () -> Unit,
    navHostController: NavHostController,
    onDrawerClicked: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        AnimatedVisibility(
            visible = navigationType == NavigationType.NavigationRail
        ) {
            PetsNavigationRail(
                onFavoriteClicked = onFavoriteClicked,
                onHomeClicked = onHomeClicked,
                onDrawerClicked = onDrawerClicked
            )
        }
        Scaffold(
            content = { paddingValues ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                ) {
                    AppNavigation(
                        contentType = contentType,
                        navHostController = navHostController
                    )
                }
            },
            bottomBar = {
                AnimatedVisibility(
                    visible = navigationType == NavigationType.BottomNavigation
                ) {
                    PetsBottomNavigationBar(
                        onFavoriteClicked = onFavoriteClicked,
                        onHomeClicked = onHomeClicked
                    )
                }
            }
        )
    }
}