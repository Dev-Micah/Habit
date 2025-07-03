package com.micahnyabuto.habit.features.habit

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.micahnyabuto.habit.core.data.local.HabitEntity
import com.micahnyabuto.habit.core.navigation.Destinations
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddHabitScreen(
    navController : NavController,
    addHabitViewModel: AddHabitViewModel = koinViewModel()
){
    var habitContent by remember { mutableStateOf("") }
    val uiState by addHabitViewModel.uiState.collectAsState()
    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Text("Add Habit")
                },

            )
        },
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(bottom = 90.dp),
                onClick = {
                    if (habitContent.isNotEmpty()) {
                        addHabitViewModel.insertHabit(habit = HabitEntity(
                            content = habitContent,
                            id =1,
                            createdAt = System.currentTimeMillis()
                        ))
                    }
                    navController.navigate(Destinations.Home)
                },
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                shape = RoundedCornerShape(100.dp)

            ){
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Add Habit"
                )
            }
        }
    ){innerpadding ->

        Column (
            modifier = Modifier.fillMaxSize()
                .padding(innerpadding),
            horizontalAlignment = Alignment.CenterHorizontally

        ){

            OutlinedTextField(
                value = habitContent,
                onValueChange = { habitContent = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(100.dp),
                placeholder = { Text("Note down a new habit....") },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    disabledBorderColor = Color.Transparent
                )
            )

        }

    }
}