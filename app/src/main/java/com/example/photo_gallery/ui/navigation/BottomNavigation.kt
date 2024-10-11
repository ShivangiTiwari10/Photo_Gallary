package com.example.photo_gallery.ui.navigation

import android.annotation.SuppressLint
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Face
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.photo_gallery.ui.screens.CollectionScreen
import com.example.photo_gallery.ui.screens.MemoriesScreen
import com.example.photo_gallery.ui.screens.PhotoScreen


val topLevelRoutes = listOf(
    TopLevelRout("Photo", Routes.PHOTO_SCREEN, Icons.Outlined.Face),
    TopLevelRout("Collection", Routes.Collections, Icons.Outlined.Face),
    TopLevelRout("Memories", Routes.Memories, Icons.Outlined.Face)
)


@SuppressLint("RestrictedApi", "UnusedMaterialScaffoldPaddingParameter")
@Composable
fun BottomNavigationGraph() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                topLevelRoutes.forEach { topLevelRoute ->
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                topLevelRoute.icon,
                                contentDescription = topLevelRoute.name
                            )
                        },
                        label = { Text(topLevelRoute.name) },
                        selected = currentDestination?.hierarchy?.any { it.route == topLevelRoute.route } == true,
                        onClick = {
                            navController.navigate(topLevelRoute.route) {
                                // Pop up to the start destination of the graph to
                                // avoid building up a large stack of destinations
                                // on the back stack as users select items
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                // Avoid multiple copies of the same destination when
                                // reselecting the same item
                                launchSingleTop = true
                                // Restore state when reselecting a previously selected item
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    )
    {
        NavHost(navController, startDestination = Routes.PHOTO_SCREEN) {

            composable(Routes.PHOTO_SCREEN) {
                PhotoScreen()
            }
            composable(Routes.Collections) {
                CollectionScreen()
            }
            composable(Routes.Memories) {
                MemoriesScreen()
            }

        }
    }
}

