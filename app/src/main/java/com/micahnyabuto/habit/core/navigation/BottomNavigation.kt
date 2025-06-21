package com.micahnyabuto.habit.core.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.QuestionAnswer
import androidx.compose.ui.graphics.vector.ImageVector

enum class BottomNavigation (
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val label: String,
    val route: Any
){
    Home(
        selectedIcon = Icons.Default.Home,
        unselectedIcon = Icons.Default.Home,
        label = "Home",
        route = Destinations.Home
    ),
    Activity(
        selectedIcon = Icons.Default.Explore,
        unselectedIcon = Icons.Default.Explore,
        label = "Activity",
        route = Destinations.Activity
    ),
    AskAi(
        selectedIcon = Icons.Default.Add,
        unselectedIcon = Icons.Default.Add,
        label = "+Habit",
        route = Destinations.Add
    ),
    Profile(
        selectedIcon = Icons.Default.Person,
        unselectedIcon = Icons.Default.Person,
        label = "Profile",
        route = Destinations.Profile
    ),


}