package com.example.homerent.ui.screen.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.homerent.R
import com.example.homerent.ui.componets.CTabBar
import com.example.homerent.ui.theme.Primary
import com.example.homerent.ui.theme.Secondary

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavHostController) {

    Scaffold {
        Column {
            CTabBar()
            Column(Modifier.padding(10.dp)) {
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(value = "",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth(),
                    trailingIcon = {
                        Icon(Icons.Filled.Search, contentDescription = null)
                    })
                Spacer(modifier = Modifier.height(10.dp))
                LazyRow() {
                    items(count = 10) {
                        Column(
                            Modifier.padding(horizontal = 10.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Box(
                                modifier = Modifier
                                    .height(60.dp)
                                    .width(60.dp)
                                    .clip(CircleShape)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_launcher_background),
                                    contentDescription = ""
                                )
                            }
                            Text(text = "Mumbai")
                        }
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Near Me")
                Spacer(modifier = Modifier.height(10.dp))
                LazyColumn {
                    items(count = 10) {
                        Box(
                            modifier = Modifier
                                .padding(10.dp)
                                .fillMaxWidth()
                                .height(150.dp)
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(color = Secondary.copy(alpha = 0.2f))
                        ) {
                            Row(modifier = Modifier
                                .padding(10.dp)) {
                                Image(
                                    painter = painterResource(R.drawable.home),
                                    contentDescription = "",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .width(140.dp).clip(RoundedCornerShape(10.dp)),
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Column {
                                    Text(text = "Parley Point, Surat", style = TextStyle(fontWeight = FontWeight.Bold))
                                    Spacer(modifier = Modifier.height(5.dp))
                                    Text(text = "Girls & Boys PG")
                                    Spacer(modifier = Modifier.height(5.dp))
                                    Text(text = "Piplod, Surat")
                                    Spacer(modifier = Modifier.height(10.dp))
                                    Text(text = "$1000", style = TextStyle(fontSize =20.sp))
                                }
                            }
                        }

                    }
                }
            }
        }
    }

}