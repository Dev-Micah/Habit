package com.micahnyabuto.habit.features.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.google.firebase.auth.FirebaseAuth
import com.micahnyabuto.habit.utils.Greeting

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(){
    val user = FirebaseAuth.getInstance().currentUser
    val photoUrl = user?.photoUrl?.toString()

    Scaffold (
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
    ){

    }
}