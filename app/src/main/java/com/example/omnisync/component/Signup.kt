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
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.navigation.NavController
import com.example.omnisync.component.shared.AppButton
import com.example.omnisync.type.ButtonType

@Composable
fun Signup(navController: NavController) {

    var username by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var contactNo by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    var isPasswordVisible by remember { mutableStateOf(false) }
    var isConfirmPasswordVisible by remember { mutableStateOf(false) }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp)
    ) {
        ElevatedCard(
            elevation = CardDefaults.elevatedCardElevation(defaultElevation = 6.dp),
            colors = CardDefaults.elevatedCardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            modifier = Modifier.padding(16.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth(0.9f)
            ) {
                Text(
                    text = "Create Account",
                    // 🌟 Scalable text style that naturally scales relative to display categories
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.Bold
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    shape = MaterialTheme.shapes.large,
                    value = username,
                    onValueChange = { username = it },
                    // 🌟 Fixed: Changed 'headlineLarge' to bodyLarge or bodyMedium for proper placeholder/label scaling
                    label = { Text(text = "Enter Username", style = MaterialTheme.typography.bodyLarge) },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Person, contentDescription = "User Icon")
                    },
                    textStyle = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(12.dp))

                OutlinedTextField(
                    shape = MaterialTheme.shapes.large,
                    value = name,
                    onValueChange = { name = it },
                    label = { Text(text = "Enter Name", style = MaterialTheme.typography.bodyLarge) },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Person, contentDescription = "User Icon")
                    },
                    textStyle = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(12.dp))

                OutlinedTextField(
                    shape = MaterialTheme.shapes.large,
                    value = contactNo,
                    onValueChange = { contactNo = it },
                    label = { Text(text = "Enter Contact no.", style = MaterialTheme.typography.bodyLarge) },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Phone, contentDescription = "Phone Icon")
                    },
                    textStyle = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(12.dp))

                OutlinedTextField(
                    shape = MaterialTheme.shapes.large,
                    value = password,
                    onValueChange = { password = it },
                    label = { Text(text = "Enter Password", style = MaterialTheme.typography.bodyLarge) },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Lock, contentDescription = "Password Icon")
                    },
                    trailingIcon = {
                        IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                            Icon(
                                imageVector = if (isPasswordVisible) Icons.Filled.VisibilityOff else Icons.Filled.Visibility,
                                contentDescription = "Toggle password visibility"
                            )
                        }
                    },
                    textStyle = MaterialTheme.typography.bodyLarge,
                    visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(12.dp))

                OutlinedTextField(
                    shape = MaterialTheme.shapes.large,
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    label = { Text(text = "Confirm Password", style = MaterialTheme.typography.bodyLarge) },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Lock, contentDescription = "Password Icon")
                    },
                    trailingIcon = {
                        IconButton(onClick = { isConfirmPasswordVisible = !isConfirmPasswordVisible }) {
                            Icon(
                                imageVector = if (isConfirmPasswordVisible) Icons.Filled.VisibilityOff else Icons.Filled.Visibility,
                                contentDescription = "Toggle confirm password visibility"
                            )
                        }
                    },
                    textStyle = MaterialTheme.typography.bodyLarge,
                    visualTransformation = if (isConfirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(24.dp))

                AppButton(
                    type = ButtonType.Tertiary,
                    onClick = {
                        println("Signing up with: $username, $name, $contactNo")
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Signup", style = MaterialTheme.typography.labelLarge)
                }

                AppButton(
                    type = ButtonType.TextButton,
                    onClick = { navController.popBackStack() }
                ) {
                    Text(text = "Have an account? Login", style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}