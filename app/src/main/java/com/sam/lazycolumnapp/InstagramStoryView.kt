package com.sam.lazycolumnapp

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.sam.lazycolumnapp.R

/**
 * 1. A horizontally scrollable list
 * 2. Load image in a circular image view
 * 3. Add circular, gradient based border around it
 */
@Composable
fun InstagramStoryView() {
    val context = LocalContext.current
    val stories = remember { (1..100).toList() }

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        itemsIndexed(
            items = stories,
            key = { index, itemId -> itemId }
        ) { index, itemId ->
            StoryItem(itemId = itemId) { itemId ->
                Toast.makeText(
                    context,
                    "You've clicked on Item $itemId at index: $index",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}

// https://picsum.photos/id/{id}/200/300
@Composable
fun StoryItem(
    modifier: Modifier = Modifier,
    itemId: Int,
    onItemClick: (itemId: Int) -> Unit
) {
    val gradientColors = listOf(Color.Red, Color.Yellow)

    Box(
        modifier = modifier
            .clip(CircleShape)
            .size(60.dp)
//            .border(2.dp, Color.Black, CircleShape)
            .border(
                width = 2.dp,
                brush = Brush.linearGradient(gradientColors),
                shape = CircleShape
            )
            .padding(4.dp)
            .background(Color.LightGray, CircleShape)
            .clickable { onItemClick(itemId) },
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            modifier = Modifier
                .clip(CircleShape)
                .fillMaxSize(),
            model = "https://picsum.photos/id/${itemId}/200/300",
            contentDescription = null,
            contentScale = ContentScale.Crop,
            placeholder = painterResource(R.drawable.placeholder),
            fallback = painterResource(R.drawable.placeholder)
        )

//        Text(
//            text = itemId.toString(),
//            style = MaterialTheme.typography.titleMedium
//        )
    }
}

@Preview
@Composable
private fun StoryItemPreview() {
    StoryItem(itemId = 1) {}
}

@Preview
@Composable
private fun InstagramStoryViewPreview() {
    InstagramStoryView()
}