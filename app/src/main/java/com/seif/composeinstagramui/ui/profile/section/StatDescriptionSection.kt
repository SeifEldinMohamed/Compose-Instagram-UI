package com.seif.composeinstagramui.ui.profile.section

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.seif.composeinstagramui.ui.models.StatDescription

@Composable
fun StatDescriptionSection(statDescription: StatDescription, modifier: Modifier = Modifier) {
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp
    Column(
        modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = statDescription.displayName,
            fontSize = 18.sp,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = statDescription.description,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight,
            fontSize = 14.sp
        )
        Text(
            text = statDescription.url,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight,
            color = Color(0xFF3D3D91),
            fontSize = 14.sp
        )

        if (statDescription.followedBy.isNotEmpty()) {
            Text(
                text = buildAnnotatedString {
                    val boldStyle = SpanStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    append("Followed by ")
                    for (index in statDescription.followedBy.indices) {
                        pushStyle(boldStyle) // Applies the given SpanStyle to any appended text until a corresponding pop is called.
                        append(statDescription.followedBy[index])
                        pop()
                        if (index >= 1) {
                            append(" and ")
                            pushStyle(boldStyle)
                            append("${statDescription.followedBy.size - 2} others")
                            break
                        }
                        if (index == 0)
                            append(", ")
                    }

                },
                letterSpacing = letterSpacing,
                lineHeight = lineHeight,
                fontSize = 14.sp
            )
        }
    }
}
