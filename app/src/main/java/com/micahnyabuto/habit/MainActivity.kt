package com.micahnyabuto.habit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.micahnyabuto.habit.features.authentication.signIn.SignInScreen
import com.micahnyabuto.habit.ui.theme.HabitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HabitTheme {
                SignInScreen()

            }
        }
    }
}

