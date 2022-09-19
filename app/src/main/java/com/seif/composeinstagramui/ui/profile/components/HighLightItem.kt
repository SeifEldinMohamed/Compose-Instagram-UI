package com.seif.composeinstagramui.ui.profile.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.seif.composeinstagramui.ui.models.HighLight

@Composable
fun HighLightItem(highLight: HighLight, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(end = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RoundImage(
            userImage = painterResource(id = highLight.image),
            modifier = modifier.size(70.dp)
        )
        Text(
            text = highLight.name,
            modifier = Modifier.padding(top = 4.dp),
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis
        )
    }
}