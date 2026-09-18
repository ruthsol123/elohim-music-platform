package com.ruthsol.elohim.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ruthsol.elohim.navigation.Screen
import com.ruthsol.elohim.navigation.bottomNavItems
import com.ruthsol.elohim.ui.home.HomeScreen
import com.ruthsol.elohim.ui.search.SearchScreen
import com.ruthsol.elohim.ui.library.LibraryScreen
import com.ruthsol.elohim.ui.profile.ProfileScreen
import com.ruthsol.elohim.ui.player.PlayerScreen
import com.ruthsol.elohim.ui.player.MiniPlayer

@Composable
fun ElohimMainApp() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute in bottomNavItems.map { it.route }) {
                ElohimBottomNavigation(navController, currentRoute)
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            NavHost(
                navController = navController,
                startDestination = Screen.Home.route,
                modifier = Modifier.fillMaxSize()
            ) {
                composable(Screen.Home.route) { HomeScreen(navController) }
                composable(Screen.Search.route) { SearchScreen(navController) }
                composable(Screen.Library.route) { LibraryScreen(navController) }
                composable(Screen.Profile.route) { ProfileScreen(navController) }
                composable(Screen.Player.route) { PlayerScreen(navController) }
            }
            
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = androidx.compose.ui.Alignment.BottomCenter) {
                if (currentRoute != Screen.Player.route) {
                    MiniPlayer(
                        onNavigateToPlayer = { navController.navigate(Screen.Player.route) }
                    )
                }
            }
        }
    }
}

@Composable
fun ElohimBottomNavigation(navController: NavHostController, currentRoute: String?) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.primary
    ) {
        bottomNavItems.forEach { screen ->
            NavigationBarItem(
                icon = { Icon(screen.icon!!, contentDescription = screen.title) },
                label = { Text(screen.title) },
                selected = currentRoute == screen.route,
                onClick = {
                    if (currentRoute != screen.route) {
                        navController.navigate(screen.route) {
                            popUpTo(Screen.Home.route) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                }
            )
        }
    }
}
