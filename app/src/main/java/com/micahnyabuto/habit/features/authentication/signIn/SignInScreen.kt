package com.micahnyabuto.habit.features.authentication.signIn


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.micahnyabuto.habit.R
import com.micahnyabuto.habit.navigation.Destinations

@Composable
fun SignInScreen(
    navController: NavController
) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 70.dp,
                start = 16.dp,
                end = 16.dp,
            top =50.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {


        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = R.drawable.illustration), // Replace with your image resource
                contentDescription = null,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))


            Text(
                buildAnnotatedString {
                    append("Welcome back to ")
                    withStyle(style = SpanStyle(
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold)) {
                        append("Habit")
                    }
                    append("+")
                },
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(24.dp))


            OutlinedTextField(
                value = "",
                onValueChange = { },
                label = { Text("Email") },
                trailingIcon = {

                    IconButton(onClick = { }) {
                        Icon(Icons.Default.Visibility, contentDescription = "Show email")
                    }

                },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = "",
                onValueChange = { },
                label = { Text("Password") },
                trailingIcon = {

                    IconButton(onClick = { }) {
                        Icon(Icons.Default.Visibility, contentDescription = "Show password")
                    }

                },
                modifier = Modifier.fillMaxWidth()
            )


            Spacer(modifier = Modifier.height(16.dp))


            Button(
                onClick = {  },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp),
                shape = RoundedCornerShape(4.dp),
                colors = ButtonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = Color.White,
                    disabledContainerColor = Color.White,
                    disabledContentColor = Color.White)
            ) {
                Text("Login")
            }

            Spacer(modifier = Modifier.height(16.dp))


            Text("or")

            Spacer(modifier = Modifier.height(16.dp))


            OutlinedButton(
                onClick = {  },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),

                shape = RoundedCornerShape(4.dp),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_google), // Replace with your Google icon
                    contentDescription = "Google",
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("SignIn with Google",
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text("Don't have an account? ")
            Text(
                text = "Register",
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable {navController.navigate(Destinations.SignUp) }
            )
        }
    }
}


