package com.micahnyabuto.habit.core.navigation

import kotlinx.serialization.Serializable

sealed class Destinations {
    @Serializable
    object Onboard

    @Serializable
    object Splash

    @Serializable
    object SignIn

    @Serializable
    object SignUp

    @Serializable
    object Home

    @Serializable
    object Activity

    @Serializable
    object Habit

    @Serializable
    object Profile

}