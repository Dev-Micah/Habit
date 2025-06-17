package com.micahnyabuto.habit.utils

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import java.util.Calendar


@Composable
fun Greeting() {
    val greetingText = greetingMessage()


    Text(
        text = greetingText,
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
    )

}

fun greetingMessage():String{
    val hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)

    return when (hour){
        in 0..5 -> "Good Night Welcome back"
        in 6..11 -> "Good Morning Welcome back"
        in 12..17 -> "Good Afternoon Welcome back"
        else -> "Good Evening Welcome back"
    }
}