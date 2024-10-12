package com.example.wishlistapp

import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
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
    TopAppBar(
        title = {
            Text(
                title,
                color = colorResource(id = R.color.dark_black),
                modifier = Modifier
                    .padding(start = 4.dp)
                    .heightIn(max = 24.dp)
            )
        },
        backgroundColor = colorResource(id = R.color.orange),
        elevation = 4.dp
        )
}