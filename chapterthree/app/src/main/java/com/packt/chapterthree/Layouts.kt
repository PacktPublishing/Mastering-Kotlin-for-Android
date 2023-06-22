package com.packt.chapterthree

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun PacktColumn() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Android")
        Text(text = "Kotlin")
        Text(text = "Compose")
    }
}

@Composable
fun PacktRow() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = "Android")
        Text(text = "Kotlin")
        Text(text = "Compose")
    }
}

@Composable
fun PacktBox() {
    Box(
        modifier = Modifier
            .size(100.dp),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier
                .size(80.dp),
            imageVector = Icons.Outlined.Notifications,
            contentDescription = null,
            tint = Color.Green
        )
        Text(text = "9")
    }
}

@Composable
fun PackLazyColumn() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        items(100) {
            Text(
                modifier = Modifier
                    .padding(8.dp),
                text = "Item number $it"
            )
        }
    }
}

@Composable
fun PackLazyRow() {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(8.dp)
    ) {
        items(100) {
            Text(
                modifier = Modifier
                    .padding(8.dp),
                text = "Item number $it"
            )
        }
    }
}

@Composable
fun PacktLazyVerticalGrid() {
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(8.dp),
        columns = GridCells.Fixed(3)
    ) {
        items(100) {
            Text(
                modifier = Modifier
                    .padding(8.dp),
                text = "Item number $it"
            )
        }
    }
}

@Composable
fun PacktLazyHorizontalGrid() {
    LazyHorizontalGrid(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(8.dp),
        rows = GridCells.Fixed(3)
    ) {
        items(100) {
            Text(
                modifier = Modifier
                    .padding(8.dp),
                text = "Item number $it"
            )
        }
    }
}

@Composable
fun PacktConstraintLayout() {
   ConstraintLayout(
    modifier = Modifier
        .padding(16.dp)
   ) {
       val (icon, text) = createRefs()
         Icon(
              modifier = Modifier
                .size(80.dp)
                .constrainAs(icon) {
                     top.linkTo(parent.top)
                     bottom.linkTo(parent.bottom)
                     start.linkTo(parent.start)
                },
              imageVector = Icons.Outlined.Notifications,
              contentDescription = null,
              tint = Color.Green
         )
       Text(
           modifier = Modifier
               .constrainAs(text) {
                   top.linkTo(parent.top)
                   bottom.linkTo(parent.bottom)
                   start.linkTo(icon.end) },
           text = "9",
           style = MaterialTheme.typography.titleLarge
       )
   }
}

@Preview(showBackground = true)
@Composable
fun PacktConstraintLayoutPreview() {
    PacktConstraintLayout()
}

@Preview(showBackground = true)
@Composable
fun PacktLazyHorizontalGridPreview() {
    PacktLazyHorizontalGrid()
}

@Preview(showBackground = true)
@Composable
fun PacktLazyVerticalGridPreview() {
    PacktLazyVerticalGrid()
}

@Preview(showBackground = true)
@Composable
fun PackLazyRowPreview() {
    PackLazyRow()
}


@Preview(showBackground = true)
@Composable
fun PackLazyColumnPreview() {
    PackLazyColumn()
}

@Preview(showBackground = true)
@Composable
fun PacktBoxPreview() {
    PacktBox()
}

@Preview(showBackground = true)
@Composable
fun PacktRowPreview() {
    PacktRow()
}

@Preview(showBackground = true)
@Composable
fun PacktColumnPreview() {
    PacktColumn()
}
