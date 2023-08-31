package com.packt.chapterseven

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import com.packt.chapterseven.navigation.AppNavigation
import com.packt.chapterseven.ui.theme.ChapterSevenTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChapterSevenTheme {
                AppNavigation()
            }
        }
    }
}