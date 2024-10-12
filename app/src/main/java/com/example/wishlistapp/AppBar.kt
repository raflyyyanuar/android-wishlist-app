package com.example.wishlistapp

import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp

@Composable
fun AppBar(
    title: String,
    onBackNavClick: () -> Unit = {}
) {

    val navigationIcon : (@Composable () -> Unit)? =
        {
            IconButton(onClick = { onBackNavClick() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    tint = colorResource(id = R.color.dark_black),
                    contentDescription = null
                )
            }
        }

    TopAppBar(
        title = {
            Text(
                title,
                color = colorResource(id = R.color.dark_black),
                modifier = Modifier
                    .heightIn(max = 24.dp)
            )
        },
        backgroundColor = colorResource(id = R.color.orange),
        elevation = 3.dp,
        navigationIcon = navigationIcon
        )
}