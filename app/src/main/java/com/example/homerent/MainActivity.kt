package com.example.homerent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.example.homerent.ui.screen.nav.NavScreen
import com.example.homerent.ui.theme.HomeRentTheme
import com.example.homerent.viewmodel.AuthViewModel
import com.example.homerent.viewmodel.AuthViewModelFactory
import com.example.homerent.viewmodel.PGViewModelFactory
import com.example.homerent.viewmodel.PgViewModel

class MainActivity : ComponentActivity() {
   private lateinit var viewModel: PgViewModel
   private lateinit var authViewModel: AuthViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this, PGViewModelFactory(this))[PgViewModel::class.java]
        authViewModel = ViewModelProvider(this, AuthViewModelFactory(this))[AuthViewModel::class.java]
        setContent {
            val navController = rememberNavController()
            HomeRentTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    NavScreen(navController,viewModel,authViewModel)
                }
            }
        }
    }
}