package com.micahnyabuto.habit.features.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.google.firebase.auth.FirebaseAuth
import com.micahnyabuto.habit.core.data.local.HabitEntity
import com.micahnyabuto.habit.features.habit.AddHabitViewModel
import org.koin.androidx.compose.koinViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    allHabits: List<HabitEntity>,
    addHabitViewModel: AddHabitViewModel = koinViewModel()
) {
    val uiState by addHabitViewModel.uiState.collectAsState()
    val user = FirebaseAuth.getInstance().currentUser
    val photoUrl = user?.photoUrl?.toString()

    LaunchedEffect(Unit) {
        addHabitViewModel.getAllHabits()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row {
                        Text("Welcome, ${user?.displayName?.lowercase() ?: "User"}")
                    }
                },
                actions = {
                    if (photoUrl != null) {
                        Image(
                            painter = rememberAsyncImagePainter(photoUrl),
                            contentDescription = "Profile Picture",
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                        )
                    } else {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Profile",
                            modifier = Modifier
                                .size(35.dp)
                                .clip(CircleShape)
                                .background(Color.LightGray)
                        )
                    }
                }
            )
        }
    ) {

        when {
            uiState.isLoading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(text = "Loading...")
                }
            }

            uiState.error != null -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(text = "Error occurred")
                }
            }

            allHabits.isEmpty() -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(text = "You haven't added any habits")
                }
            }

            else -> {
                HabitList(
                    habits = allHabits,
                    onDeleteHabit = addHabitViewModel::deleteHabit
                )
            }
        }
    }

}

@Composable
private fun HabitList(
    habits: List<HabitEntity>,
    onDeleteHabit: (HabitEntity) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
            .fillMaxWidth(1f)
            .padding(top = 100.dp),

    ) {
        items(habits) { habit ->
            HabitItemRow(
                habit = habit,
                onDelete = { onDeleteHabit(habit) }
            )
        }
    }
}

@Composable
private fun HabitItemRow(
    habit: HabitEntity,
    onDelete: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = habit.content,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Medium
                    ),
                    modifier = Modifier.padding(bottom = 4.dp)
                )

                habit.frequency?.takeIf { it.isNotBlank() }?.let { freq ->
                    Text(
                        text = freq,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                    )
                }
            }

            IconButton(onClick = onDelete) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete habit",
                    tint = MaterialTheme.colorScheme.error
                )
            }
        }
    }
}