package com.example.homerent.ui.componets

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.homerent.R
import com.example.homerent.ui.theme.Primary


@Composable
fun CTabBar(leadClick:() -> Unit) {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            Modifier
                .height(60.dp)
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    painterResource(id = R.drawable.logo),
                    contentDescription = "",
                    Modifier
                        .height(45.dp)
                        .width(45.dp)
                        .clip(CircleShape).clickable { leadClick() }
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "PG.com")


            }
        }

        Divider(color = Color.Gray, modifier = Modifier.width(350.dp))
    }

}