package com.example.omnisync.component

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable

@Serializable
object LoginScreenRoute
@Serializable
object SignupSreenRoute

@Composable
fun AppNavigator() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = LoginScreenRoute
    ) {
        composable<LoginScreenRoute> {
            Login(navController)
        }

        composable<SignupSreenRoute>{
            Signup(navController)
        }
    }
}