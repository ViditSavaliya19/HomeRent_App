package com.example.homerent.ui.componets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ListTile(
    leading: ImageVector? = null,
    title: String,
    titleWeight: FontWeight?=FontWeight.Normal,
    titleSize:Int?=16,
    subtitle: String? = null,
    subTitleWeight: FontWeight?=FontWeight.Normal,
    subTitleSize:Int?=13,
    trailing: ImageVector?=null, onTap:()->Unit = {}
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(horizontal = 10.dp).clickable { onTap() },
        verticalAlignment = Alignment.CenterVertically,
    ) {
        leading?.let {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(60.dp), contentAlignment = Alignment.Center
            ) {
                Icon(it, contentDescription = null)
            }
        }
        Spacer(modifier = Modifier.width(10.dp))
        Column {
            Text(title, style = TextStyle(fontWeight = titleWeight, fontSize = titleSize!!.sp))
            subtitle?.let { Text(it,style = TextStyle(fontWeight = subTitleWeight, fontSize = subTitleSize!!.sp)) }
        }
        Spacer(modifier = Modifier.weight(1f))
        trailing?.let { Icon(it, contentDescription = null) }
    }


}