package com.example.homerent.ui.screen.login

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import com.example.homerent.viewmodel.AuthViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginScreen(navController: NavHostController, authViewModel: AuthViewModel) {

    var txtEmail = remember {
        mutableStateOf("")
    }
    var txtPassword = remember {
        mutableStateOf("")
    }

    val coroutineScope = rememberCoroutineScope()

    Scaffold {
        Image(
            painterResource(id = R.drawable.bg),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column {
            Spacer(modifier = Modifier.weight(1f))
            Box(
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(
                            topStart = 20.dp, topEnd = 20.dp
                        )
                    )
                    .background(color = Color.White)
                    .weight(1f)
                    .fillMaxWidth()
            ) {

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp)

                ) {

                    Text(text = "Login", style = TextStyle(fontSize = 25.sp, color = Primary))
                    Spacer(modifier = Modifier.height(10.dp))
                    OutlinedTextField(
                        value = txtEmail.value,
                        onValueChange = {
                            txtEmail.value = it
                        },
                        label = { Text("Email") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        modifier = Modifier.fillMaxWidth(),
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    OutlinedTextField(
                        value = txtPassword.value,
                        onValueChange = {
                            txtPassword.value = it
                        },
                        label = { Text("Password") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        modifier = Modifier.fillMaxWidth()

                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    CButton(label = "Login") {

                        coroutineScope.launch {
                            var isLogin: Boolean = false
                            async {
                                isLogin = authViewModel.login(txtEmail.value, txtPassword.value)
                            }.await()
                            authViewModel.currentUser()
                            if (isLogin) {
                                navController.navigate("profile")

                            } else {
                                Toast.makeText(
                                    navController.context,
                                    "Failed To Login",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }

                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))

                    TextButton(onClick = { navController.navigate("signup") }) {
                        Text("Create new account? SignUp")
                    }


                }

            }
        }
    }

}