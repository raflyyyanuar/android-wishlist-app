package com.example.wishlistapp

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun AppBar(
    title: String,
    onBackNavClick: () -> Unit = {}
) {

    val navigationIcon : (@Composable () -> Unit)? =
        if(!title.contentEquals("Wishlist", true)) {
            {
                IconButton(onClick = { onBackNavClick() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                        tint = colorResource(id = R.color.orange),
                        contentDescription = null
                    )
                }
            }
        } else {
            null
        }

    TopAppBar(
        title = {
            if(title.contentEquals("wishlist", true)) {
                Text(
                    "Wish",
                    color = colorResource(id = R.color.white),
                    modifier = Modifier
                        .heightIn(max = 24.dp),
                    fontWeight = FontWeight.ExtraBold
                )
                Spacer(modifier = Modifier.width(2.dp))
                Card(
                    backgroundColor = colorResource(id = R.color.orange)
                ) {
                    Text(
                        "list",
                        color = colorResource(id = R.color.black),
                        modifier = Modifier
                            .padding(horizontal = 3.dp)
                            .heightIn(max = 24.dp),
                        fontWeight = FontWeight.ExtraBold
                    )
                }
            }
            else {
                Text(
                    title,
                    color = colorResource(id = R.color.white),
                    modifier = Modifier
                        .heightIn(max = 24.dp),
                    fontWeight = FontWeight.ExtraBold
                )
            }
        },
        backgroundColor = colorResource(id = R.color.extra_dark_gray),
        navigationIcon = navigationIcon,
        )
}