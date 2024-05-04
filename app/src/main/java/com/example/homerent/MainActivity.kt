package com.example.homerent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.example.homerent.ui.screen.nav.NavScreen
import com.example.homerent.ui.theme.HomeRentTheme
import com.example.homerent.viewmodel.PGViewModelFactory
import com.example.homerent.viewmodel.PgViewModel

class MainActivity : ComponentActivity() {
   private lateinit var viewModel: PgViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this, PGViewModelFactory(this))[PgViewModel::class.java]

        setContent {
            val navController = rememberNavController()
            HomeRentTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavScreen(navController,viewModel)
                }
            }
        }
    }
}