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
import androidx.compose.ui.unit.dp


@Composable
fun ListTile(
    leading: ImageVector? = null,
    title: String,
    subtitle: String? = null,
    trailing: ImageVector?=null,onTap:()->Unit = {}
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
            Text(title)
            subtitle?.let { Text(it) }
        }
        Spacer(modifier = Modifier.weight(1f))
        trailing?.let { Icon(it, contentDescription = null) }
    }


}