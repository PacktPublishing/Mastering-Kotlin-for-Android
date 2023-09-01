package com.packt.chapterseven

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.packt.chapterseven.navigation.AppNavigation
import com.packt.chapterseven.ui.theme.ChapterSevenTheme

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