package com.seif.composeinstagramui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.seif.composeinstagramui.ui.profile.ProfileScreen
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
                        ProfileScreen(
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
                                )
                            )
                        )
                    }
                }
            }
        }
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
                ProfileScreen(
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
                        )
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
)