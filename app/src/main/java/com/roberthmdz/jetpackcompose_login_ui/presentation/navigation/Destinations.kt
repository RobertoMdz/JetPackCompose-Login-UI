package com.roberthmdz.jetpackcompose_login_ui.presentation.navigation

import androidx.navigation.compose.NamedNavArgument

sealed class Destinations(
    val route: String,
    val arguments: List<NamedNavArgument>
) {
    object Login: Destinations("login", emptyList())
    object Register: Destinations("register", emptyList())
    object Home: Destinations("home", emptyList())
}
