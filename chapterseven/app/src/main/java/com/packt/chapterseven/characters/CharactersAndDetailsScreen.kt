package com.packt.chapterseven.characters

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable

@Composable
fun CharacterAndDetailsScreen(navigationOptions: NavigationOptions) {
    Row {
        CharacterListScreen()
        CharacterDetails(character = 1)
    }
}