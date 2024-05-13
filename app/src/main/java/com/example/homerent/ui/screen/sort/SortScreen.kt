package com.example.homerent.ui.screen.sort

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.homerent.ui.componets.CButton
import com.example.homerent.ui.componets.CTabBar
import com.example.homerent.ui.componets.ListTile
import com.example.homerent.viewmodel.PgViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

private const val i = 10

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SortScreen(navController: NavHostController, viewModel: PgViewModel) {
    var txtCity = remember { mutableStateOf("") }
    var txtState = remember { mutableStateOf("") }
    var txtArea = remember { mutableStateOf("") }
    var txtTypeAll = remember { mutableStateOf(true) }
    var txtTypePrivate = remember { mutableStateOf(false) }
    var txtTypeShared = remember { mutableStateOf(false) }
    var txtCategoryBoth = remember { mutableStateOf(true) }
    var txtCategoryBoys = remember { mutableStateOf(false) }
    var txtCategoryGirls = remember { mutableStateOf(false) }
    var rent = remember { mutableStateOf(1000f..5000f) }
    val coroutineScope = rememberCoroutineScope()


    Scaffold {
        Column(Modifier.padding(it), horizontalAlignment = Alignment.CenterHorizontally) {
            CTabBar(title = "Filter")
            Spacer(modifier = Modifier.height(10.dp))
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Text("Location", style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold))
                Divider()
                Spacer(modifier = Modifier.height(10.dp))
                TextField(
                    value = txtState.value,
                    onValueChange = { txtState.value = it },
                    placeholder = {
                        Text(
                            text = "State"
                        )
                    },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(10.dp))
                TextField(
                    value = txtCity.value,
                    onValueChange = { txtCity.value = it },
                    placeholder = {
                        Text(
                            text = "City"
                        )
                    },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(10.dp))
                TextField(
                    value = txtArea.value,
                    onValueChange = { txtArea.value = it },
                    placeholder = {
                        Text(
                            text = "Area"
                        )
                    },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text("Rent", style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold))
                Divider()
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "${rent.value.start.toInt()} - ${rent.value.endInclusive.toInt()}")
                RangeSlider(
                    value = rent.value, onValueChange = {
                        rent.value = it
                    }, steps = 10, valueRange = 1000f..10000f
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text("Types", style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold))
                Divider()
                Spacer(modifier = Modifier.height(10.dp))
                Row {
                    FilterChip(selected = txtTypeAll.value, onClick = {
                        txtTypeAll.value = true
                        txtTypePrivate.value = false
                        txtTypeShared.value = false
                    }, label = { Text("All") })
                    Spacer(modifier = Modifier.width(10.dp))
                    FilterChip(selected = txtTypePrivate.value, onClick = {
                        txtTypeAll.value = false
                        txtTypePrivate.value = true
                        txtTypeShared.value = false
                    }, label = { Text("Private") })
                    Spacer(modifier = Modifier.width(10.dp))
                    FilterChip(selected = txtTypeShared.value, onClick = {
                        txtTypeAll.value = false
                        txtTypePrivate.value = false
                        txtTypeShared.value = true
                    }, label = { Text("Shared") })
                }
                Spacer(modifier = Modifier.height(20.dp))
                Text("Category", style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold))
                Divider()
                Spacer(modifier = Modifier.height(10.dp))
                Row {
                    FilterChip(selected = txtCategoryBoth.value, onClick = {
                        txtCategoryBoth.value = true
                        txtCategoryBoys.value = false
                        txtCategoryGirls.value = false
                    }, label = { Text("Both") })
                    Spacer(modifier = Modifier.width(10.dp))
                    FilterChip(
                        selected = txtCategoryBoys.value,
                        onClick = {
                            txtCategoryBoys.value = true
                            txtCategoryGirls.value = false
                            txtCategoryBoth.value = false
                        },
                        label = { Text("Only Boys") })
                    Spacer(modifier = Modifier.width(10.dp))
                    FilterChip(
                        selected = txtCategoryGirls.value,
                        onClick = {
                            txtCategoryBoys.value = false
                            txtCategoryGirls.value = true
                            txtCategoryBoth.value = false
                        },
                        label = { Text("Only Girls") })
                }
                Spacer(modifier = Modifier.height(20.dp))
                CButton(label = "Apply") {
                    val query = HashMap<String, String>()
                    query["state"] = txtState.value
                    query["city"] = txtCity.value
                    query["area"] = txtArea.value
                    query["type"] = if (txtTypeAll.value) "" else if (txtTypePrivate.value) "private" else "shared"
                    query["category"] = if (txtCategoryBoth.value) "" else if (txtCategoryBoys.value) "boys" else "girls"
                    query["min"] = "${rent.value.start.toInt()}"
                    query["max"] = "${rent.value.endInclusive.toInt()}"

                    coroutineScope.launch {
                        async {
                            viewModel.getSortedPGList(query)
                        }.await()
                        navController.popBackStack()

                    }

                }
            }

        }
    }
}