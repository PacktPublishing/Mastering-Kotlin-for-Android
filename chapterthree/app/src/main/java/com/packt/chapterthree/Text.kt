package com.packt.chapterthree

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PacktPublishing(bookName: String) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.Green),
        text = "Title of the book is: $bookName"
    )
}

@Preview(showBackground = true)
@Composable
fun PacktPublishingPreview() {
    PacktPublishing("Android Development with Kotlin")
}