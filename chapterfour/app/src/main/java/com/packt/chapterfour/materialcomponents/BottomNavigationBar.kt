package com.packt.chapterfour.materialcomponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.packt.chapterfour.ui.theme.ChapterFourTheme

@Composable
fun PacktBottomNavigationBar() {
    NavigationBar (
        content = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Rounded.Home,
                    contentDescription = "Home Screen"
                )
                Icon(
                    imageVector = Icons.Rounded.ShoppingCart,
                    contentDescription = "Cart Screen"
                )
                Icon(
                    imageVector = Icons.Rounded.AccountCircle,
                    contentDescription = "Account Screen"
                )
            }
        }
    )
}


@Preview
@Composable
fun PacktBottomNavigationBarPreview() {
    ChapterFourTheme {
        PacktBottomNavigationBar()
    }
}