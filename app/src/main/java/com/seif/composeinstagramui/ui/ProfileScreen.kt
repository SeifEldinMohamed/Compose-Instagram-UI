package com.seif.composeinstagramui.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.seif.composeinstagramui.*
import com.seif.composeinstagramui.ui.components.ButtonsSection
import com.seif.composeinstagramui.ui.components.ProfileDetailsSection
import com.seif.composeinstagramui.ui.components.StatDescriptionSection
import com.seif.composeinstagramui.ui.components.TopBarSection

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
        Spacer(modifier = Modifier.height(16.dp))
    }

}


