package com.seif.composeinstagramui.ui.models

data class StatDescription(
    val displayName: String,
    val description: String,
    val url: String,
    val followedBy: List<String>,
)