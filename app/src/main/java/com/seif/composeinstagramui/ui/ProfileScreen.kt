package com.seif.composeinstagramui.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.seif.composeinstagramui.*
import com.seif.composeinstagramui.R
import com.seif.composeinstagramui.ui.components.*

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    accountName: String,
    userImage: Painter,
    postsNumber: String,
    followers: String,
    following: String,
    statDescription: StatDescription
) {
    Column(modifier = modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(12.dp))
        TopBarSection(accountName, modifier)
        Spacer(modifier = Modifier.height(12.dp))
        ProfileDetailsSection(userImage, postsNumber, followers, following)
        Spacer(modifier = Modifier.height(8.dp))
        StatDescriptionSection(statDescription)
        Spacer(modifier = Modifier.height(16.dp))
        ButtonsSection()
        Spacer(modifier = Modifier.height(12.dp))
        HighLightsSection(createHighLightList(), modifier.padding(start = 10.dp))
    }

}

fun createHighLightList(): List<HighLight> {
    return listOf(
        HighLight(R.drawable.zamalek, "Zamalek ❤"),
        HighLight(R.drawable.zamalek_shirt, "Shirt 2022"),
        HighLight(R.drawable.shika, "Legend 😎"),
        HighLight(R.drawable.seif_ecpc, "ECPC"),
        HighLight(R.drawable.seif_crop, "raye2")
    )
}

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

data class HighLight(
    val image: Int,
    val name: String
)
