package com.packt.chapterseven.materialcomponents

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.packt.chapterseven.ui.theme.ChapterSevenTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PacktSmallTopAppBar() {
    TopAppBar(
        title = {
            Text(text = "Packt Publishing")
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PackMediumTopAooBar() {
    MediumTopAppBar(
        title = {
            Text(text = "Packt Publishing")
        }
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PackLargeTopBar() {
    LargeTopAppBar(
        title = {
            Text(text = "Packt Publishing")
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PacktCenterAlignedTopBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(text = "Packt Publishing")
        }
    )
}

@Preview
@Composable
fun PacktSmallTopAppBarPreview() {
    ChapterSevenTheme {
        PacktSmallTopAppBar()
    }
}

@Preview
@Composable
fun PackMediumTopAppBarPreview() {
    ChapterSevenTheme {
        PackMediumTopAooBar()
    }
}

@Preview
@Composable
fun PackLargeTopBarPreview() {
    ChapterSevenTheme {
        PackLargeTopBar()
    }
}

@Preview
@Composable
fun PacktCenterAlignedTopBarPreview() {
    ChapterSevenTheme {
        PacktCenterAlignedTopBar()
    }
}