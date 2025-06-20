package com.micahnyabuto.habit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.micahnyabuto.habit.core.navigation.AppNavHost
import com.micahnyabuto.habit.core.navigation.Destinations
import com.micahnyabuto.habit.features.onboard.OnboardingScreen
import com.micahnyabuto.habit.ui.theme.HabitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HabitTheme {
                val navController = rememberNavController()
                AppNavHost(
                    navController=navController
                )
            }
        }
    }
}

