package com.seif.composeinstagramui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.seif.composeinstagramui.ui.theme.ComposeInstagramUiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeInstagramUiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        UpperSection(
                            accountName = "Seif_Mohamed",
                            userImage = painterResource(id = R.drawable.seif_crop),
                            postsNumber = "100",
                            followers = "99.8K",
                            following = "75",
                            statDescription = StatDescription(
                                displayName = "Programming Mentor",
                                description = "10 years of coding experience\n" +
                                        "Want me to make your app? Send me an email!\n" +
                                        "Subscribe to my YouTube channel!",
                                url = "https://youtube.com/c/PhilippLackner",
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
                                ),
                                otherCount = 17
                            )
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun UpperSection(
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
        AccountDetailsSection(userImage, postsNumber, followers, following)
        Spacer(modifier = Modifier.height(8.dp))
        StatDescriptionSection(statDescription)
        Spacer(modifier = Modifier.height(16.dp))
        ButtonsSection()
    }

}

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


@Composable
fun AccountDetailsSection(
    userImage: Painter,
    postsNumber: String,
    followers: String,
    following: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier.fillMaxWidth()
    ) {
        RoundImage(userImage, modifier.size(100.dp))
        Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = postsNumber,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Posts",
                fontSize = 14.sp,
                color = Color.DarkGray,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
        Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = followers,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Followers",
                fontSize = 14.sp,
                color = Color.DarkGray,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
        Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = following,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Following",
                fontSize = 14.sp,
                color = Color.DarkGray,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

@Composable
fun RoundImage(
    userImage: Painter,
    modifier: Modifier = Modifier
) {
    Image(
        painter = userImage,
        contentDescription = "user image",
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = CircleShape
            )
            .padding(3.dp)
            .clip(CircleShape)
    )

}

@Composable
fun TopBarSection(title: String, modifier: Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_back),
            contentDescription = "arrow back",
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = title,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_bell),
            contentDescription = "bell",
            modifier = Modifier.size(24.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_dotmenu),
            contentDescription = "dot menu",
            modifier = Modifier.size(24.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeInstagramUiTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                UpperSection(
                    accountName = "Seif_Mohamed",
                    userImage = painterResource(id = R.drawable.seif_crop),
                    postsNumber = "100",
                    followers = "99.8K",
                    following = "75",
                    statDescription = StatDescription(
                        displayName = "Programming Mentor",
                        description = "10 years of coding experience\n" +
                                "Want me to make your app? Send me an email!\n" +
                                "Subscribe to my YouTube channel!",
                        url = "https://youtube.com/c/PhilippLackner",
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
                        ),
                        otherCount = 17
                    )
                )
            }
        }
    }
}

data class StatDescription(
    val displayName: String,
    val description: String,
    val url: String,
    val followedBy: List<String>,
    val otherCount: Int
)