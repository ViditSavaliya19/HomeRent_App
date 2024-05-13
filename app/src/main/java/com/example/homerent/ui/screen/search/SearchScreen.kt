package com.example.homerent.ui.screen.search

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.homerent.R
import com.example.homerent.ui.componets.NetworkIndicator
import com.example.homerent.ui.theme.Secondary
import com.example.homerent.viewmodel.PgViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SearchScreen(navController: NavHostController, viewModel: PgViewModel) {

    val search = rememberSaveable {
        mutableStateOf("")
    }
    val list = viewModel.sortedPGList.observeAsState()


    Scaffold(modifier = Modifier.padding(10.dp)) {
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = { },
                    content = { Icon(Icons.Filled.ArrowBack, contentDescription = "back") })
                OutlinedTextField(
                    value = search.value,
                    onValueChange = {
                        search.value = it
                    },
                    placeholder = { Text("City") },
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(30.dp),
                )

                OutlinedIconButton(onClick = {
                    navController.navigate("Sort")
                }) {
                    Icon(Icons.Outlined.Settings, contentDescription = "")
                }
            }

            Spacer(modifier = Modifier.height(10.dp))
            list.value?.let { it1 ->
                LazyColumn {
                    items(count = it1.size) {
                        Box(
                            modifier = Modifier
                                .padding(10.dp)
                                .fillMaxWidth()
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(color = Secondary.copy(alpha = 0.2f))
                                .clickable {

                                    viewModel.selectedPG = it1[it]
                                    navController.navigate("PGDetails")
                                }
                        ) {
                            Column(
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.home),
                                    contentDescription = "",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .height(200.dp)
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(10.dp)),
                                )
                                Spacer(modifier = Modifier.height(5.dp))
                                Column(
                                    modifier = Modifier
                                        .padding(10.dp)
                                ) {

                                    Text(
                                        text = "${it1[it].name}",
                                        style = TextStyle(
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 20.sp
                                        )
                                    )
                                    Spacer(modifier = Modifier.height(5.dp))
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Icon(
                                            Icons.Filled.LocationOn,
                                            contentDescription = null,
                                            modifier = Modifier.height(15.dp)
                                        )
                                        Spacer(modifier = Modifier.width(5.dp))
                                        Text(
                                            text = "${it1[it].area},${it1[it].city},${it1[it].postalcode}",
                                            style = TextStyle(fontSize = 14.sp)
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(10.dp))
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Icon(
                                            Icons.Filled.Person,
                                            contentDescription = null,
                                            modifier = Modifier.height(15.dp)
                                        )
                                        Spacer(modifier = Modifier.width(5.dp))
                                        Text(
                                            text = "${it1[it].category}",
                                            style = TextStyle(fontSize = 14.sp)
                                        )
                                    }

                                    Spacer(modifier = Modifier.height(10.dp))
                                    Text(text = "Monthly Rent", style = TextStyle(fontSize = 12.sp))
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                    ) {
                                        Text(
                                            text = "$${it1[it].rent}",
                                            style = TextStyle(
                                                fontSize = 20.sp,
                                                fontWeight = FontWeight.Bold
                                            )
                                        )
                                        Text(
                                            text = " / Per Bed",
                                        )
                                    }

                                }
                            }
                        }

                    }
                }
            } ?: NetworkIndicator()

        }

    }
}