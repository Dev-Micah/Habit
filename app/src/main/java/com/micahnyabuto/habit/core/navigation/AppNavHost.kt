package com.micahnyabuto.habit.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.firebase.auth.FirebaseAuth
import com.micahnyabuto.habit.features.auth.signIn.SignInScreen
import com.micahnyabuto.habit.features.auth.signUp.SignUpScreen
import com.micahnyabuto.habit.features.home.HomeScreen
import com.micahnyabuto.habit.features.onboard.OnboardingScreen

@Composable
fun AppNavHost(
    modifier: Modifier= Modifier,
    navController: NavHostController
){
    val isLoggedIn = FirebaseAuth.getInstance().currentUser != null

    NavHost(
        modifier = Modifier,
        startDestination = if (isLoggedIn) Destinations.Home else Destinations.SignIn,
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

        composable <Destinations.Onboard>{
            OnboardingScreen(
                onSwiped = {
                navController.navigate(Destinations.Home) {
                    popUpTo(Destinations.Home){
                        inclusive=true
                    }
                }
                }
            )
        }
    }

}