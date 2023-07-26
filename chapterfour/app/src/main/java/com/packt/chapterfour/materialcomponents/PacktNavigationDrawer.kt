package com.packt.chapterfour.materialcomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PacktNavigationDrawer(onDrawerClicked: () -> Unit = {}) {
    Column(
        modifier = Modifier.fillMaxHeight()
    ) {
        Text(text = "Characters")
        NavigationDrawerItem(
            label = { Text(text = "Home") },
            selected = false ,
            onClick = { /*TODO*/ },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null
                )
            }
        )

        NavigationDrawerItem(
            label = { Text(text = "Cart") },
            selected = false ,
            onClick = { /*TODO*/ },
            icon = {
                Icon(
                    imageVector = Icons.Rounded.ShoppingCart,
                    contentDescription = "Cart Screen"
                )
            }
        )

        NavigationDrawerItem(
            label = {  Text(text = "Account") },
            selected = false ,
            onClick = { /*TODO*/ },
            icon = {
                Icon(
                    imageVector = Icons.Rounded.AccountCircle,
                    contentDescription = "Account Screen"
                )
            }
        )
    }
}