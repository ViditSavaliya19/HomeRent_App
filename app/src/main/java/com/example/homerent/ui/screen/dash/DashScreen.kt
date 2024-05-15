package com.example.homerent.ui.screen.dash

import android.annotation.SuppressLint
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.homerent.ui.screen.home.HomeScreen
import com.example.homerent.ui.screen.search.SearchScreen
import com.example.homerent.ui.screen.settings.SettingsScreen
import com.example.homerent.ui.theme.Primary
import com.example.homerent.viewmodel.AuthViewModel
import com.example.homerent.viewmodel.PgViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DashScreen(
    navController: NavHostController, viewModel: PgViewModel, authViewModel: AuthViewModel
) {

    var screenList = listOf("Home", "Search", "ShortList", "Chat", "Profile")
    var selectedScreen = remember { mutableStateOf(screenList[0]) }

    Scaffold(bottomBar = {
        NavigationBar(
            containerColor = Color.White,
        ) {
            screenList.forEach {
                NavigationBarItem(
                    selected = it == selectedScreen.value,
                    label = { Text(it) },
                    onClick = {
                        selectedScreen.value = it
                    },
                    icon = { Icon( getIconForScreen(screen = it) , contentDescription = null)},
                    interactionSource = MutableInteractionSource(),
                    colors = NavigationBarItemDefaults.colors(
                        unselectedTextColor = Color.Black,
                        selectedTextColor = Primary,
                        unselectedIconColor = Color.Gray,
                        selectedIconColor = Primary,
                        indicatorColor = Color.White
                    ),

                )
            }
        }
    }) {
        Box(Modifier.padding(bottom = 70.dp)) {
            when (selectedScreen.value) {
                "Home" -> HomeScreen(navController, viewModel, authViewModel)
                "Search" -> SearchScreen(navController, viewModel)
                "ShortList" -> Text(text = "ShortList")
                "Chat" -> Text(text = "Chat")
                "Profile" -> SettingsScreen(navController,authViewModel)
            }
        }

    }
    
}

@Composable
fun getIconForScreen(screen: String): ImageVector {
    return when (screen) {
        "Home" -> Icons.Outlined.Home
        "Search" -> Icons.Outlined.Search
        "SortList" -> Icons.Outlined.Favorite
        "Chat" -> Icons.Outlined.Email
        "Profile" -> Icons.Outlined.AccountCircle
        else -> Icons.Default.Home
    }
}