package com.micahnyabuto.habit.features.home.component

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import com.micahnyabuto.habit.features.home.Greeting

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(){
    Scaffold (
        topBar = {
            TopAppBar(
                title = { Greeting()}
            )
        }
    ){

    }
}