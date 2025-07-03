package com.micahnyabuto.habit.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.firebase.auth.FirebaseAuth
import com.micahnyabuto.habit.core.data.local.HabitEntity
import com.micahnyabuto.habit.features.activity.ActivityScreen
import com.micahnyabuto.habit.features.auth.signIn.SignInScreen
import com.micahnyabuto.habit.features.auth.signUp.SignUpScreen
import com.micahnyabuto.habit.features.habit.AddHabitScreen
import com.micahnyabuto.habit.features.habit.AddHabitViewModel
import com.micahnyabuto.habit.features.home.HomeScreen
import com.micahnyabuto.habit.features.onboard.OnboardingScreen
import com.micahnyabuto.habit.features.profile.ProfileScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun AppNavHost(
    modifier: Modifier= Modifier,
    viewModel: AddHabitViewModel,
    navController: NavHostController
){
    val uiState by viewModel.uiState.collectAsState()
    val addHabitViewModel :AddHabitViewModel = koinViewModel()
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
            HomeScreen(
                allHabits = uiState.habits,
                addHabitViewModel = addHabitViewModel
            )
        }
        composable <Destinations.Activity>{
            ActivityScreen()
        }
        composable <Destinations.Habit>{
            AddHabitScreen(
                navController =navController
            )
        }

        composable <Destinations.Profile>{
            ProfileScreen()
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