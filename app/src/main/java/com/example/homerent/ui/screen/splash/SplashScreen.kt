package com.example.homerent.ui.screen.splash

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.homerent.R
import com.example.homerent.viewmodel.AuthViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "CoroutineCreationDuringComposition")
@Composable
fun SplashScreen(navController: NavHostController, authViewModel: AuthViewModel) {

    rememberCoroutineScope().launch {
        delay(3000)
        if(authViewModel.user!=null)
        {
            navController.navigate("home")
            {
                popUpTo("splash")
                {
                    inclusive = true
                }
            }

        }
        else
        {
            navController.navigate("login")
            {
                popUpTo("splash")
                {
                    inclusive = true
                }
            }
        }

    }

    Scaffold {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "",
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
            )
        }
    }
}