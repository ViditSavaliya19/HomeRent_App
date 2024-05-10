package com.example.homerent.ui.screen.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.homerent.ui.screen.home.HomeScreen
import com.example.homerent.ui.screen.login.LoginScreen
import com.example.homerent.ui.screen.login.SignUpScreen
import com.example.homerent.ui.screen.pg.PGDetailsScreen
import com.example.homerent.ui.screen.profile.ProfileScreen
import com.example.homerent.ui.screen.splash.SplashScreen
import com.example.homerent.viewmodel.AuthViewModel
import com.example.homerent.viewmodel.PgViewModel

@Composable
fun NavScreen(
    navController: NavHostController,
    viewModel: PgViewModel,
    authViewModel: AuthViewModel
) {
    NavHost(navController = navController, startDestination = "splash")
    {
        composable("splash")
        {
            SplashScreen(navController,authViewModel)
        }

        composable("login")
        {
            LoginScreen(navController,authViewModel)
        }
        composable("signup")
        {
            SignUpScreen(navController,authViewModel)
        }
        composable("home")
        {
            HomeScreen(navController,viewModel,authViewModel)
        }
        composable("profile")
        {
            ProfileScreen(navController,viewModel,authViewModel)
        }

        composable("PGDetails")
        {
            PGDetailsScreen(navController,viewModel)
        }
    }
}