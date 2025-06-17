package com.micahnyabuto.habit.core.navigation

import androidx.compose.ui.graphics.vector.ImageVector

enum class BottomNavigation (
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val label: String,
    val route: Any
){

}