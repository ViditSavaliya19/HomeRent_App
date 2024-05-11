package com.example.homerent.ui.screen.pg

import android.annotation.SuppressLint
import android.content.Intent
import android.webkit.WebView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import com.example.homerent.R
import com.example.homerent.ui.componets.CButton
import com.example.homerent.ui.componets.CTabBar
import com.example.homerent.ui.componets.ListTile
import com.example.homerent.viewmodel.PgViewModel
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SetJavaScriptEnabled")
@Composable
fun PGDetailsScreen(
    navController: NavHostController,
    viewModel: PgViewModel,
) {

    Scaffold {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            CTabBar ()
            Spacer(modifier = Modifier.height(10.dp))
            Image(
                painter = painterResource(id = R.drawable.home),
                contentDescription = "ph",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .padding(12.dp)
            ) {
                Row {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(text = "Name", style = TextStyle(fontSize = 12.sp))
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            text = "${viewModel.selectedPG?.name}",
                            style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        )
                    }

                    ElevatedButton(onClick = {

                        var intent = Intent(Intent.ACTION_DIAL)
                        intent.data =
                            android.net.Uri.parse("tel:+91${viewModel.selectedPG?.contact}")
                        navController.context.startActivity(intent)

                    }) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Filled.Call, contentDescription = "call")
                            Spacer(modifier = Modifier.width(5.dp))
                            Text("Call")
                        }
                    }

                }

                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "Details", style = TextStyle(fontSize = 12.sp))
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    OptionTile(icon = Icons.Outlined.Lock, s = "\$ ${viewModel.selectedPG?.rent}")
                    OptionTile(
                        icon = Icons.Outlined.CheckCircle,
                        s = "${viewModel.selectedPG?.type}"
                    )
                    OptionTile(
                        icon = Icons.Outlined.Person,
                        s = "${viewModel.selectedPG?.category}"
                    )
                    OptionTile(icon = Icons.Outlined.Face, s = "${viewModel.selectedPG?.bed} Bed")
                }
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "Location", style = TextStyle(fontSize = 12.sp))
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    OptionTile(img = R.drawable.fan, s = "2 Fan")
                    OptionTile(img = R.drawable.ac, s = "1 AC")
                    OptionTile(img = R.drawable.light, s = "3 Light")
                    OptionTile(img = R.drawable.ref, s = "1 Fridge")
                }
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "House Rules", style = TextStyle(fontSize = 12.sp))
                Spacer(modifier = Modifier.height(10.dp))
                Column(
                    verticalArrangement = Arrangement.SpaceAround,
                ) {
                    ListTile(title = "Deposit", subtitle = "\$5000", titleWeight = FontWeight.Bold)
                    ListTile(
                        title = "Notice Period",
                        subtitle = "1 Month",
                        titleWeight = FontWeight.Bold
                    )
                    ListTile(
                        title = "Electricity Charges",
                        subtitle = "-",
                        titleWeight = FontWeight.Bold
                    )
                    ListTile(
                        title = "Parking",
                        subtitle = "Available",
                        titleWeight = FontWeight.Bold
                    )
                    ListTile(title = "Wifi", subtitle = "Available", titleWeight = FontWeight.Bold)
                }

                CButton(label = "Location") {
                    var intent = Intent(Intent.ACTION_VIEW)
                    intent.data =
                        android.net.Uri.parse("https://www.google.com/maps/place/${viewModel.selectedPG!!.area},${viewModel.selectedPG!!.city},${viewModel.selectedPG!!.state},${viewModel.selectedPG!!.postalcode}")
                    navController.context.startActivity(intent)
                }

            }


        }
    }

}

@Composable
private fun OptionTile(icon: ImageVector? = null, img: Int? = null, s: String) {
    Box(
        modifier = Modifier
            .height(80.dp)
            .width(80.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color = Color.Gray.copy(alpha = 0.1f)), contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            icon?.let { Icon(it, contentDescription = "rent") }
            img?.let {
                Image(
                    painter = painterResource(id = img),
                    contentDescription = "rent",
                    modifier = Modifier
                        .height(30.dp)
                        .width(30.dp)
                )
            }
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = s,
                textAlign = TextAlign.Center,
                style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
            )
        }
    }
}