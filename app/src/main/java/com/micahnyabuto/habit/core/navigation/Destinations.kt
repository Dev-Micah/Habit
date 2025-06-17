package com.micahnyabuto.habit.core.navigation

import kotlinx.serialization.Serializable

sealed class Destinations {
    @Serializable
    object SignIn

    @Serializable
    object SignUp

    @Serializable
    object Home
}