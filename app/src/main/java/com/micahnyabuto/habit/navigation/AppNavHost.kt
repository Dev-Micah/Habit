package com.micahnyabuto.habit.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.micahnyabuto.habit.features.authentication.signIn.SignInScreen
import com.micahnyabuto.habit.features.authentication.signUp.SignUpScreen
import com.micahnyabuto.habit.features.home.HomeScreen

@Composable
fun AppNavHost(
    modifier: Modifier= Modifier,
    navController: NavHostController
){
    NavHost(
        modifier = Modifier,
        startDestination = Destinations.SignIn,
        navController= navController
    ) {
        composable<Destinations.SignIn> {
            SignInScreen(navController =navController)
        }
        composable <Destinations.SignUp>{
            SignUpScreen(navController =navController)
        }

        composable <Destinations.Home>{
            HomeScreen()
        }
    }

}