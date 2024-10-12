package com.example.wishlistapp

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.wishlistapp.data.Wish

@Composable
fun HomeView() {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            AppBar(
                title = "Wishlist",
                onBackNavClick = {
                    Toast.makeText(
                        context,
                        "Button Clicked!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            )},
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    Toast.makeText(
                        context,
                        "Add Button Clicked!",
                        Toast.LENGTH_SHORT
                    ).show()
                },
                modifier = Modifier
                    .padding(20.dp),
                contentColor = colorResource(id = R.color.dark_black),
                backgroundColor = colorResource(id = R.color.orange)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {

        }
    }
}

@Composable
fun WishItem(
    wish: Wish,
    onClick: () -> Unit
) {
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, start = 8.dp, end = 8.dp)
            .clickable { onClick() },
        elevation = 10.dp,
        backgroundColor = colorResource(id = R.color.white)
    ) {
        Column(
            modifier = Modifier
                .padding(4.dp)
        ) {
            Text(wish.title, fontWeight = FontWeight.ExtraBold)
            Text(wish.description)
        }
    }
}