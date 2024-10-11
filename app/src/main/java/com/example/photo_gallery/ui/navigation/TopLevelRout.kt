package com.example.photo_gallery.ui.navigation

import androidx.compose.ui.graphics.vector.ImageVector

data class TopLevelRout<T : Any>(val name: String, val route: T, val icon: ImageVector)
