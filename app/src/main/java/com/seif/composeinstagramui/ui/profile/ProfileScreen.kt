package com.seif.composeinstagramui.ui.profile

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.seif.composeinstagramui.R
import com.seif.composeinstagramui.ui.models.HighLight
import com.seif.composeinstagramui.ui.models.StatDescription
import com.seif.composeinstagramui.ui.profile.section.*

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
) {
    val accountName = "Seif_Mohamed"
    val userImage = painterResource(id = R.drawable.seif_crop)
    val postsNumber = "100"
    val followers = "99.8K"
    val following = "75"
    val statDescription = createStatDescription()

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

fun createStatDescription(): StatDescription  {
    return StatDescription(
        displayName = "Android Software Engineer",
        description = "3 years of coding experience\n" +
                "Want me to make your app? Send me an email!\n" +
                "See my apps on Google Play!",
        url = "https://play.google.com/store/apps/dev?id=8697500693164992079&hl=ar&gl=US",
        followedBy = listOf(
            "Hazem_Khaled",
            "Google",
            "mohamed",
            "ahmed",
            "kareem",
            "nora",
            "zamalek",
            "heba",
            "gogo",
            "youssef"
        )
    )
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

