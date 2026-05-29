package com.example.omnisync.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.omnisync.component.shared.AppButton
import com.example.omnisync.component.shared.Loader
import com.example.omnisync.type.ButtonType



@Composable
fun Login(navController: NavController) {
    // 1. Swapped to the standard delegation 'by' syntax for cleaner layout variables
    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf<Boolean>(false) }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {

        ElevatedCard(
            elevation = CardDefaults.elevatedCardElevation(defaultElevation = 6.dp),
            colors = CardDefaults.elevatedCardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            modifier = Modifier
                .padding(16.dp)

        ) {
            // 2. FIXED: Changed LazyColumn to a regular Column since a login form doesn't need infinite lazy scrolling mechanics
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(24.dp) // Added cleaner inner breathing space
                    .fillMaxWidth(0.9f)
            ) {
                Text(
                    text = "Welcome back!",
                    fontSize = 24.sp, // Made slightly bigger for better visual hierarchy
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(16.dp)) // Adds a clean layout gap

                OutlinedTextField(
                    value = userName,
                    onValueChange = { userName = it },
                    label = { Text(text = "Enter Username") },
                    shape = MaterialTheme.shapes.large,
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "User Icon"
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(12.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    shape = MaterialTheme.shapes.large,
                    label = { Text(text = "Enter Password") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = "password icon"
                        )
                    },

                    visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(24.dp))


                AppButton(
                    type = ButtonType.Tertiary,
                    onClick = { isLoading = !isLoading},
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = if (isLoading) "Cancel" else "Login")
                }


                AppButton(
                    type = ButtonType.TextButton,
                    onClick = { navController.navigate(SignupSreenRoute) },

                    ) {
                    Text("Don't have account ? Signup")
                }
            }

        }
        if(isLoading ){
            Loader()
        }
    }

}