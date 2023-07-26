package com.packt.chapterseven.materialcomponents

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.packt.chapterseven.ui.theme.ChapterSevenTheme

@Composable
fun PacktBottomNavigationBar() {
    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = MaterialTheme.colorScheme.background,
        content = {
            NavigationBarItem(
                selected = false, onClick = { /*TODO*/ },
                icon = {
                    Icon(
                        imageVector = Icons.Rounded.Home,
                        contentDescription = "Home Screen"
                    )
                },
                label = {
                    Text(text = "Home")
                }
            )

            NavigationBarItem(
                selected = false, onClick = { /*TODO*/ },
                icon = {
                    Icon(
                        imageVector = Icons.Rounded.ShoppingCart,
                        contentDescription = "Cart Screen"
                    )
                },
                label = {
                    Text(text = "Cart")
                }
            )

            NavigationBarItem(
                selected = false, onClick = { /*TODO*/ },
                icon = {
                    Icon(
                        imageVector = Icons.Rounded.AccountCircle,
                        contentDescription = "Account Screen"
                    )
                },
                label = {
                    Text(text = "Account")
                }
            )
        }
    )
}


@Preview
@Composable
fun PacktBottomNavigationBarPreview() {
    ChapterSevenTheme {
        PacktBottomNavigationBar()
    }
}