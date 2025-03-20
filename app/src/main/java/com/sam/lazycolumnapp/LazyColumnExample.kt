package com.sam.lazycolumnapp

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
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
    val scrollState = rememberScrollState()
    Column (
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = scrollState)
    ){
        list.forEach{ item ->
            ListItem(
                modifier = Modifier
                    .padding(vertical = 12.dp, horizontal = 8.dp)
                    .fillMaxWidth(),
                item = item
            )
        }
    }
}

//@Composable
//fun LazyColumnExample(modifier: Modifier = Modifier) {
//    val list = remember { (1..100).map { "Item $it" } }
//
//    LazyColumn {
//
//     }
//}

@Composable
fun ListItem(
    modifier: Modifier = Modifier,
    item: String
) {
    Log.d("TAG", "ListItem: $item")
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
