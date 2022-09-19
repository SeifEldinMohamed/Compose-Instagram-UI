package com.seif.composeinstagramui.ui.profile.section

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.seif.composeinstagramui.R
import com.seif.composeinstagramui.ui.models.ImageWithText
import com.seif.composeinstagramui.ui.models.Post
import com.seif.composeinstagramui.ui.profile.components.PostTabView

@Composable
fun TabViewSection(modifier: Modifier = Modifier) {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    PostTabView(imageWithTexts = createImageWithTextsList(), onTabSelected = {
        selectedTabIndex = it
    })

    when(selectedTabIndex){
        0 -> {
            PostSection(createPostList())
        }
    }

}


fun createImageWithTextsList(): List<ImageWithText> {
    return listOf(
        ImageWithText(
            image =  R.drawable.ic_grid,
            text = "Posts"
        ),
        ImageWithText(
            image =  R.drawable.ic_reels,
            text = "Reels"
        ),
        ImageWithText(
            image =  R.drawable.ic_person,
            text = "profile"
        )
    )
}


private fun createPostList(): List<Post> {
    return listOf(
        Post(R.drawable.seif_crop, "seif crop"),
        Post(R.drawable.seif_ecpc, "seif ecpc"),
        Post(R.drawable.shika, "shika"),
        Post(R.drawable.zizo, "zizo"),
        Post(R.drawable.shika_king, "shika king"),
        Post(R.drawable.cairo_white, "cairo white"),
        Post(R.drawable.zamalek_shirt, "zamalek shirt"),
        Post(R.drawable.zamalek, "zamalek")
    )
}
