package com.sam.lazycolumnapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ScrollableColumnExample() {
    val list = remember { (1..100).map { "Item $it" } }
    Column (
        modifier = Modifier.fillMaxSize().verticalScroll()
    ){
        list.forEach{ item ->
            ListItem(
                modifier = Modifier
                    .padding(vertical = 12.dp, horizontal = 8.dp)
                    .fillMaxWidth(),
                item = item)
        }
    }
}

@Composable
fun ListItem(
    modifier: Modifier = Modifier,
    item: String
) {
    Card(modifier = modifier) {
        Row(
            modifier = modifier.padding(8.dp)
        ) {
            Text(
                text = item,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Preview
@Composable
fun ScrollableColumnExamplePreview(modifier: Modifier = Modifier) {
    ScrollableColumnExample()
}
