package com.example.homerent.ui.screen.profile

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.homerent.R
import com.example.homerent.ui.componets.CButton
import com.example.homerent.viewmodel.PgViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

@Composable
fun ProfileScreen(navController: NavHostController, viewModel: PgViewModel) {

    var txtName = rememberSaveable {
        mutableStateOf("")
    }

    var txtMobile = rememberSaveable {
        mutableStateOf("")
    }

    var txtPostalCode = rememberSaveable {
        mutableStateOf("")
    }
    var txtCity = rememberSaveable {
        mutableStateOf("")
    }
    var txtState = rememberSaveable {
        mutableStateOf("")
    }
    var txtArea = rememberSaveable {
        mutableStateOf("")
    }
    var txtProfession = rememberSaveable {
        mutableStateOf("")
    }
    var txtEmail = rememberSaveable {
        mutableStateOf("")
    }

    var coroutineScope = rememberCoroutineScope()

    Scaffold {
        Column(
            Modifier
                .padding(it)
                .fillMaxSize()
                .padding(10.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painterResource(id = R.drawable.logo),
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
                value = txtEmail.value,
                onValueChange = {
                    txtEmail.value = it
                },
                placeholder = { Text("Email") },
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
                value = txtArea.value,
                onValueChange = {
                    txtArea.value = it
                },
                placeholder = { Text("Area") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(10.dp))

            TextField(
                value = txtPostalCode.value,
                onValueChange = {
                    txtPostalCode.value = it
                },
                placeholder = { Text("PostalCode") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(10.dp))


            TextField(
                value = txtProfession.value,
                onValueChange = {
                    txtProfession.value = it
                },
                placeholder = { Text("Profession") },

                modifier = Modifier.fillMaxWidth()

            )

            Spacer(modifier = Modifier.height(10.dp))



            CButton(label = "Edit Profile") {
                var data = HashMap<String,String>()

                data.set("name",txtName.value)
                data.set("email",txtEmail.value)
                data.set("mobile",txtMobile.value)
                data.set("state",txtState.value)
                data.set("city",txtCity.value)
                data.set("area",txtArea.value)
                data.set("postalcode",txtPostalCode.value)
                data.set("profession",txtProfession.value)

                coroutineScope.launch {
                    var res :Boolean = false
                    async {
                      res =  viewModel.postUserDetails(data)
                    }.await()

                    if(res)
                    {
                        navController.navigate("home")
                    }
                    else{
                        Toast.makeText(navController.context,"Something went wrong",Toast.LENGTH_SHORT).show()
                    }

                }

            }
        }
    }

}