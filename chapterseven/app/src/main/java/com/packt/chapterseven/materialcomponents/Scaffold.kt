package com.packt.chapterseven.materialcomponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.packt.chapterseven.ui.theme.ChapterSevenTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PacktScaffold() {
    Scaffold(
        topBar = {
            PacktSmallTopAppBar()
        },
        bottomBar = {
            PacktBottomNavigationBar()

        },
        floatingActionButton = {
            PacktFloatingActionButton()
        },
        content = { paddingValues ->
           Column(
               modifier = Modifier
                   .fillMaxSize()
                   .padding(paddingValues)
                   .background(Color.Gray.copy(alpha = 0.1f)),
               verticalArrangement = Arrangement.Center,
               horizontalAlignment = Alignment.CenterHorizontally
           ) {
              Text(
                  modifier = Modifier.padding(10.dp),
                  text = "Mastering Kotlin for Android Development - Chapter 4",
                  textAlign = TextAlign.Center
              )
           }
        }
    )
}

@Preview
@Composable
fun PacktScaffoldPreview() {
   ChapterSevenTheme {
       PacktScaffold()
   }
}