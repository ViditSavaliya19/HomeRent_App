package com.example.homerent.ui.screen.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.homerent.ui.screen.home.HomeScreen

@Composable
fun NavScreen(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home")
    {
        composable("splash")
        {

        }

        composable("login")
        {
            HomeScreen(navController)
        }
        composable("signUp")
        {
            HomeScreen(navController)
        }
        composable("home")
        {
            HomeScreen(navController)
        }
    }
}