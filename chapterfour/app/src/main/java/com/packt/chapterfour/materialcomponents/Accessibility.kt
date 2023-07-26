package com.packt.chapterfour.materialcomponents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.unit.dp
import com.packt.chapterfour.R

@Composable
fun IconWithContentDescription() {
    Icon(
        modifier = Modifier.size(48.dp),
        painter = painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = "Icon"
    )
}

@Composable
fun TextWithClickableLabel() {
    Text(
        modifier = Modifier
            .clickable(
                onClick = { /*TODO*/ },
                onClickLabel = "Click Me"
            )
            .padding(10.dp),
        text = "Click Me"

    )
}

@Composable
fun HeadingSemantics() {
    Text(
        modifier = Modifier
            .semantics { heading() }
            .padding(10.dp),
        text = "Heading One"
    )
}

@Composable
fun StateDescriptionSemantics() {
    Button(
        modifier = Modifier
            .semantics { stateDescription = "Disabled" }
            .padding(10.dp),
        onClick = { /*TODO*/ },
        enabled = false
    ) {
        Text(text = "Disabled Button")
    }
}

@Composable
fun ColumnWithMergedDescendants() {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .semantics(mergeDescendants = true) { }
    ) {
        Text(text = "Heading One")
        Text(text = "Heading Two")
        Text(text = "Heading Three")
    }
}