package com.example.homerent.ui.screen.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.homerent.ui.screen.home.HomeScreen
import com.example.homerent.ui.screen.login.LoginScreen
import com.example.homerent.ui.screen.login.SignUpScreen
import com.example.homerent.ui.screen.profile.ProfileScreen

@Composable
fun NavScreen(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home")
    {
        composable("splash")
        {

        }

        composable("login")
        {
            LoginScreen(navController)
        }
        composable("signup")
        {
            SignUpScreen(navController)
        }
        composable("home")
        {
            HomeScreen(navController)
        }
        composable("profile")
        {
            ProfileScreen(navController)
        }
    }
}