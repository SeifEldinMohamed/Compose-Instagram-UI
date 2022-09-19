package com.seif.composeinstagramui.ui.profile.section

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.seif.composeinstagramui.R


@Composable
fun ButtonsSection(modifier: Modifier = Modifier) {
    val minWidth = 140.dp
    val height = 32.dp
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly) {
        Button(
            onClick = { },
            modifier
                .defaultMinSize(minWidth = minWidth) // Constrain the size of the wrapped layout only when it would be otherwise unconstrained: the minWidth and minHeight constraints are only applied when the incoming corresponding constraint is 0.
                .height(height),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray)
        ) {
            Text(text = "Following", color = Color.Black, fontSize = 12.sp)
            Icon(Icons.Default.KeyboardArrowDown, contentDescription = "keyboard arrow down")
        }
        Button(
            onClick = {},
            modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray)
        ) {
            Text(text = "Followers", color = Color.Black, fontSize = 12.sp)
        }
        Button(
            onClick = {  },
            modifier
                .defaultMinSize(minWidth = 40.dp)
                .height(height),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray)
        ) {
            Icon(painter = painterResource(id = R.drawable.add_friend), contentDescription ="add friend")
        }
    }
}

