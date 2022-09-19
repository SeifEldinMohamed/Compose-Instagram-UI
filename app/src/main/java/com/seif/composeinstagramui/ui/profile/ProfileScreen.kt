package com.seif.composeinstagramui.ui.profile

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.seif.composeinstagramui.*
import com.seif.composeinstagramui.R
import com.seif.composeinstagramui.ui.models.HighLight
import com.seif.composeinstagramui.ui.models.Post
import com.seif.composeinstagramui.ui.profile.section.*

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
        Spacer(modifier = Modifier.height(10.dp))
        ProfileDetailsSection(userImage, postsNumber, followers, following)
        Spacer(modifier = Modifier.height(8.dp))
        StatDescriptionSection(statDescription)
        Spacer(modifier = Modifier.height(16.dp))
        ButtonsSection()
        Spacer(modifier = Modifier.height(12.dp))
        HighLightsSection(createHighLightList(), modifier.padding(start = 10.dp))
        Spacer(modifier = Modifier.height(8.dp))
        TabViewSection()
    }

}



private fun createHighLightList(): List<HighLight> {
    return listOf(
        HighLight(R.drawable.zamalek, "Zamalek ❤"),
        HighLight(R.drawable.zamalek_shirt, "Shirt 2022"),
        HighLight(R.drawable.shika, "Legend 😎"),
        HighLight(R.drawable.seif_ecpc, "ECPC"),
        HighLight(R.drawable.seif_crop, "raye2")
    )
}

