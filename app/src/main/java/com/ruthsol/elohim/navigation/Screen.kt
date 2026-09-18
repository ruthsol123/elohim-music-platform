package com.ruthsol.elohim.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val title: String, val icon: ImageVector? = null) {
    object Home : Screen("home", "Home", Icons.Default.Home)
    object Search : Screen("search", "Search", Icons.Default.Search)
    object Library : Screen("library", "Library", Icons.Default.List)
    object Profile : Screen("profile", "Profile", Icons.Default.Person)
    
    object Player : Screen("player", "Player")
    object SongDetails : Screen("song_details/{songId}", "Song Details") {
        fun createRoute(songId: String) = "song_details/$songId"
    }
}

val bottomNavItems = listOf(
    Screen.Home,
    Screen.Search,
    Screen.Library,
    Screen.Profile
)
