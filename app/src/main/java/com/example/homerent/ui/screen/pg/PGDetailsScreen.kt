package com.example.homerent.ui.screen.pg

import android.annotation.SuppressLint
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
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
import androidx.navigation.NavHostController
import com.example.homerent.R
import com.example.homerent.ui.componets.CTabBar
import com.example.homerent.viewmodel.PgViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PGDetailsScreen(
    navController: NavHostController,
    viewModel: PgViewModel,
) {

    Scaffold {
        Column {
            CTabBar {

            }
            Spacer(modifier = Modifier.height(10.dp))
            Image(
                painter = painterResource(id = R.drawable.home),
                contentDescription = "ph",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.padding(12.dp)) {
                Text(text = "Name", style = TextStyle(fontSize = 12.sp))
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "Surat PG",
                    style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
                )

                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "Details", style = TextStyle(fontSize = 12.sp))
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    OptionTile(icon = Icons.Outlined.Lock, s = "\$ ${viewModel.selectedPG?.rent}")
                    OptionTile(icon = Icons.Outlined.CheckCircle, s = "Shared")
                    OptionTile(icon = Icons.Outlined.Person, s = "Boys")
                    OptionTile(icon = Icons.Outlined.Face, s = "5 Bed")
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
                style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
            )
        }
    }
}