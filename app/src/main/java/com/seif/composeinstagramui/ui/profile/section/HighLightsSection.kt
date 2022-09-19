package com.seif.composeinstagramui.ui.profile.section

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.seif.composeinstagramui.ui.profile.components.HighLightItem
import com.seif.composeinstagramui.ui.models.HighLight

@Composable
fun HighLightsSection(
    highlights: List<HighLight>,
    modifier: Modifier = Modifier
) {
    LazyRow(modifier = modifier
        .fillMaxWidth()
        .padding(end = 12.dp)) {
        items(highlights.size) {
            HighLightItem(highlights[it])
        }
    }
}