package com.example.homerent.ui.screen.login

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.homerent.R
import com.example.homerent.ui.componets.CButton
import com.example.homerent.ui.theme.Primary

@Preview
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SignUpScreen(navController: NavHostController) {
    var txtEmail = remember {
        mutableStateOf("")
    }
    var txtPassword = remember {
        mutableStateOf("")
    }

    Scaffold {
        Image(
            painterResource(id = R.drawable.bg),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Box(
            modifier = Modifier.fillMaxHeight(), contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .clip(
                        RoundedCornerShape(
                           20.dp
                        )
                    )
                    .background(color = Color.White)
                    .height(350.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp)

                ) {

                    Text(text = "SingUp", style = TextStyle(fontSize = 25.sp, color = Primary))
                    Spacer(modifier = Modifier.height(10.dp))
                    OutlinedTextField(
                        value = txtEmail.value,
                        onValueChange = {
                            txtEmail.value = it
                        },
                        label = { Text("Email") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        modifier = Modifier.fillMaxWidth()

                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    OutlinedTextField(
                        value = txtEmail.value,
                        onValueChange = {
                            txtEmail.value = it
                        },
                        label = { Text("Password") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        modifier = Modifier.fillMaxWidth()

                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    CButton(label = "SingUp") {

                    }
                    Spacer(modifier = Modifier.height(20.dp))

                    TextButton(onClick = { navController.popBackStack()}) {
                        Text("Already account! Sign In")
                    }

                }

            }
        }
    }

}