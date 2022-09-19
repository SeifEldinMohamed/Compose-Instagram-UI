package com.seif.composeinstagramui.ui.profile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
fun RoundImage(
    userImage: Painter,
    modifier: Modifier = Modifier
) {
    Image(
        painter = userImage,
        contentDescription = "user image",
        modifier = modifier
            .aspectRatio(
                1f,
                matchHeightConstraintsFirst = true
            ) // 1f: to make sure that it's a square, matchHeightConstraintsFirst = true : it will firstly look at the height of the image then adjust the width accordingly
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = CircleShape
            )
            .padding(3.dp) // to add space between image and border
            .clip(CircleShape)
    )
}