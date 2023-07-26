package com.packt.chapterseven.characters

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.packt.chapterseven.materialcomponents.PacktBottomNavigationBar
import com.packt.chapterseven.materialcomponents.PacktNavigationDrawer
import com.packt.chapterseven.materialcomponents.PacktNavigationRail
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharactersScreen(navigationOptions: NavigationOptions, showDetails: Boolean) {
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    if (navigationOptions == NavigationOptions.NavigationDrawer) {
        PermanentNavigationDrawer(
            drawerContent = { PacktNavigationDrawer() },
            content = {
               CharactersScreenContent(
                   navigationOptions = navigationOptions,
                   showDetails = showDetails
               )
            }
        ) 
    } else {
            ModalNavigationDrawer(
                drawerContent = {
                    PacktNavigationDrawer(
                        onDrawerClicked = {
                            scope.launch {
                                drawerState.close()
                            }
                        }
                    ) },
                content = {
                    CharactersScreenContent(
                        navigationOptions = navigationOptions,
                        showDetails = showDetails
                    )
                },
                drawerState = drawerState
            )

        }
    }

@Composable
fun CharactersScreenContent(navigationOptions: NavigationOptions, showDetails: Boolean) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier.fillMaxSize()
        ) {
            AnimatedVisibility(
                visible = navigationOptions == NavigationOptions.NavigationRail
            ) {
                PacktNavigationRail()
            }

            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Box(
                    modifier = Modifier.weight(1f)
                ) {
                    if (showDetails) {
                        CharacterDetails(character = 1)
                    } else {
                        CharacterListScreen()
                    }
                }
                AnimatedVisibility(
                    visible = navigationOptions == NavigationOptions.BottomNavigation
                ) {
                    PacktBottomNavigationBar()
                }
            }
        }
    }
}

@Composable
fun CharacterListScreen() {
    LazyColumn {
        items(20) {
            CharacterListItem(character = it)
        }
    }
}