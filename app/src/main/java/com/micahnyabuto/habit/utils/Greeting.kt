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
        in 0..5 -> "Good Night "
        in 6..11 -> "Good Morning "
        in 12..17 -> "Good Afternoon"
        else -> "Good Evening"
    }
}