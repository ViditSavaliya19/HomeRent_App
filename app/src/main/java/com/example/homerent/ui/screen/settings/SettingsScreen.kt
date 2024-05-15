package com.example.homerent.ui.screen.settings

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavHostController
import com.example.homerent.R
import com.example.homerent.ui.componets.CTabBar
import com.example.homerent.ui.componets.ListTile
import com.example.homerent.viewmodel.AuthViewModel

//@Preview(showBackground = true)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SettingsScreen(navController: NavHostController, authViewModel: AuthViewModel) {

    var user = authViewModel.userDataList.observeAsState()

    Scaffold {
        Column {
            CTabBar()
            ListTile(
                leading = Icons.Outlined.AccountCircle,
                title = "${user.value!![0].name}",
                subtitle = "${user.value!![0].email}"
            )

            ListTile(
                leading = Icons.Outlined.Info,
                title = "Support",
                subtitle = "Help & Contact Us"
            )

            ListTile(
                leading = Icons.Outlined.Email,
                title = "Terms & Conditions",
                subtitle = "Understand the Terms"
            )

            ListTile(
                leading = Icons.Outlined.Warning,
                title = "Privacy Policy",
                subtitle = "Details of privacy policy"
            )
            ListTile(
                leading = Icons.Outlined.Settings,
                title = "Settings",
                subtitle = "Manage your account"
            )
            ListTile(
                onTap = {
                    authViewModel.logout()
                    navController.navigate("login")
                    {
                        popUpTo("home")
                        {
                            inclusive = true
                        }

                    }
                },
                leading = ImageVector.vectorResource(id = R.drawable.baseline_logout_24),
                title = "Logout",
                subtitle = "Sign out Account"
            )
        }
    }

}