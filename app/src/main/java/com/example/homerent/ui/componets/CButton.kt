package com.example.homerent.ui.componets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.homerent.ui.theme.Primary

@Preview
@Composable
fun CButton(label:String,click: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .padding(vertical = 10.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color = Primary)
            .clickable {
                click()
            },
        contentAlignment = Alignment.Center
    ) {
        Text("$label", style = TextStyle(color = Color.White, fontSize = 20.sp))
    }
}