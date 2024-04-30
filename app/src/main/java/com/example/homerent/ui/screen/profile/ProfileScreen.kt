package com.example.homerent.ui.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.homerent.R
import com.example.homerent.ui.componets.CButton

@Composable
fun ProfileScreen(navController: NavHostController) {

    var txtName = rememberSaveable {
        mutableStateOf("")
    }

    var txtMobile = rememberSaveable {
        mutableStateOf("")
    }

    var txtAddress = rememberSaveable {
        mutableStateOf("")
    }
    var txtCity = rememberSaveable {
        mutableStateOf("")
    }
    var txtState = rememberSaveable {
        mutableStateOf("")
    }

    Scaffold {
        Column(
            Modifier
                .padding(it)
                .fillMaxSize()
                .padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "",
                Modifier
                    .height(100.dp)
                    .width(100.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.height(10.dp))

            TextField(
                value = txtName.value,
                onValueChange = {
                    txtName.value = it
                },
                placeholder = { Text("Full Name") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(10.dp))


            TextField(
                value = txtMobile.value,
                onValueChange = {
                    txtMobile.value = it
                },
                placeholder = { Text("Mobile") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(10.dp))


            TextField(
                value = txtAddress.value,
                onValueChange = {
                    txtAddress.value = it
                },
                placeholder = { Text("Address") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(10.dp))


            TextField(
                value = txtCity.value,
                onValueChange = {
                    txtCity.value = it
                },
                placeholder = { Text("City") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(10.dp))


            TextField(
                value = txtState.value,
                onValueChange = {
                    txtState.value = it
                },
                placeholder = { Text("State") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(10.dp))

            CButton(label = "Edit Profile") {
                navController.navigate("home")
            }
        }
    }

}