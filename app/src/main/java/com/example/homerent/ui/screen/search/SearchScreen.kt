package com.example.homerent.ui.screen.search

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.homerent.viewmodel.PgViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SearchScreen(modifier: NavHostController, viewModel: PgViewModel) {

    val search = rememberSaveable {
        mutableStateOf("")
    }

    Scaffold(modifier = Modifier.padding(10.dp)) {
        Column {
            Row {
                IconButton(onClick = { },
                    content = { Icon(Icons.Filled.ArrowBack, contentDescription = "back") })
                OutlinedTextField(value = search.value,
                    onValueChange = {
                        search.value = it
                    },
                    placeholder = { Text("City") },
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(30.dp),
                )

            }

            Spacer(modifier = Modifier.height(10.dp))
            OutlinedButton(onClick = {  }) {
                Row{
                    Icon(Icons.Filled.Done, contentDescription = "filter")
                    Text("Filter")
                }
            }

        }

    }
}