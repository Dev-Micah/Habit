package com.micahnyabuto.habit.core.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
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

//    Activity(
//        selectedIcon = Icons.Default.Explore,
//        unselectedIcon = Icons.Default.Explore,
//        label = "Activity",
//        route = Destinations.Activity
//    ),
    Add(
        selectedIcon = Icons.Default.Edit,
        unselectedIcon = Icons.Default.Edit,
        label = "+Habit",
        route = Destinations.Habit
    ),
    Profile(
        selectedIcon = Icons.Default.Person,
        unselectedIcon = Icons.Default.Person,
        label = "Profile",
        route = Destinations.Profile
    ),


}