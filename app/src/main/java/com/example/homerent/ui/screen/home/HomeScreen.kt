package com.example.homerent.ui.screen.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDismissState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.homerent.R
import com.example.homerent.ui.componets.CTabBar
import com.example.homerent.ui.componets.ListTile
import com.example.homerent.ui.componets.NetworkIndicator
import com.example.homerent.ui.theme.Secondary
import com.example.homerent.viewmodel.PgViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavHostController, viewModel: PgViewModel) {

    val list = viewModel.pgList.observeAsState()
    val cityList = viewModel.cityList.observeAsState()
    var drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = { Drawer() }
    ) {
        Scaffold {
            LazyColumn {
                item {
                    CTabBar(leadClick = {
                        coroutineScope.launch {
                            drawerState.apply {
                                if (isClosed) open() else close()
                            }
                        }
                    })
                }
                item {
                    Spacer(modifier = Modifier.height(10.dp))
                }
                item {
                    LazyRow(Modifier.padding(10.dp)) {
                        cityList.value?.let { it1 ->
                            items(count = it1.size) {
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
                                            painter = painterResource(id = R.drawable.city),
                                            contentDescription = ""
                                        )
                                    }
                                    Text(text = "${it1[it].city}")
                                }
                            }
                        } ?: item { NetworkIndicator() }
                    }
                }
                item {
                    Spacer(modifier = Modifier.height(10.dp))
                }
                item {
                    Text(text = "Near Me", modifier = Modifier.padding(horizontal = 10.dp))
                }
                item {
                    Spacer(modifier = Modifier.height(10.dp))
                }

                list.value?.let { it1 ->
                    items(count = it1.size) {
                        Box(
                            modifier = Modifier
                                .padding(10.dp)
                                .fillMaxWidth()
                                .height(150.dp)
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(color = Secondary.copy(alpha = 0.2f))
                        ) {
                            Row(
                                modifier = Modifier
                                    .padding(10.dp)
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.home),
                                    contentDescription = "",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .width(140.dp)
                                        .clip(RoundedCornerShape(10.dp)),
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Column {
                                    Text(
                                        text = "${it1[it].name}",
                                        style = TextStyle(fontWeight = FontWeight.Bold)
                                    )
                                    Spacer(modifier = Modifier.height(5.dp))
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
                                    Spacer(modifier = Modifier.height(5.dp))
                                    Divider()
                                    Spacer(modifier = Modifier.weight(1f))
                                    Text(
                                        text = "${it1[it].category}",
                                        style = TextStyle(fontSize = 14.sp)
                                    )
                                    Spacer(modifier = Modifier.height(5.dp))
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Icon(
                                            Icons.Filled.LocationOn,
                                            contentDescription = null,
                                            modifier = Modifier.height(15.dp)
                                        )
                                        Text(
                                            text = "${it1[it].area},${it1[it].city},${it1[it].postalcode}",
                                            style = TextStyle(fontSize = 14.sp)
                                        )
                                    }
                                }
                            }
                        }

                    }
                } ?: item {
                    NetworkIndicator()
                }


            }
        }
    }
}

@Composable
fun Drawer() {
    ModalDrawerSheet {
        ListTile(title = "LogOut", trailing = Icons.Filled.ExitToApp){
            Log.e("TAG", "Drawer: LogOut", )
        }
        ListTile(
            leading = Icons.Filled.Settings,
            title = "Settings",
            subtitle = "Test",
            trailing = Icons.Filled.ExitToApp
        )
    }
}
