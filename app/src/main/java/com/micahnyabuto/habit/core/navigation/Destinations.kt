package com.micahnyabuto.habit.navigation

import kotlinx.serialization.Serializable

sealed class Destinations {
    @Serializable
    object SignIn

    @Serializable
    object SignUp

    @Serializable
    object Home
}