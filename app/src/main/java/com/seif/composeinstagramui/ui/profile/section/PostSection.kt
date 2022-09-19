package com.seif.composeinstagramui.ui.profile.section

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.seif.composeinstagramui.ui.models.Post

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PostSection(posts: List<Post>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(cells = GridCells.Fixed(3), modifier = modifier.fillMaxSize()) {
        items(posts.size) {
            Image(
                painter = painterResource(id = posts[it].image),
                contentDescription = posts[it].description,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .size(140.dp)
                    .border(
                    width = 1.dp,
                    color = Color.White
                )
            )
        }
    }
}