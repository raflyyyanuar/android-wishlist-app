package com.example.wishlistapp

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.DismissDirection
import androidx.compose.material.DismissValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.Scaffold
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.rememberDismissState
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.wishlistapp.data.DummyWish
import com.example.wishlistapp.data.Wish

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeView(
    viewModel: WishViewModel,
    navController: NavHostController,
) {
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
                    navController.navigate( "${Screen.AddScreen.route}/0L")
                },
                modifier = Modifier
                    .padding(20.dp),
                contentColor = colorResource(id = R.color.cream),
                backgroundColor = colorResource(id = R.color.light_green)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    tint = colorResource(id = R.color.black)
                )
            }
        },
        backgroundColor = colorResource(id = R.color.dark_green)
    ) {
        val wishes = viewModel.getWishes.collectAsState(initial = listOf())
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            items(wishes.value, key = { wish -> wish.id }) { wish ->
                val dismissState = rememberDismissState(
                    confirmStateChange = { it ->
                        if(it == DismissValue.DismissedToStart) {
                            viewModel.deleteWish(wish)
                        }
                        true
                    }
                )

                SwipeToDismiss(
                    state = dismissState,
                    background = {
                        Card (
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(top = 8.dp, start = 8.dp, end = 8.dp),
                            elevation = 4.dp,
                            backgroundColor = colorResource(id = R.color.light_green),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(end = 8.dp)
                                ,
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.End
                            ) {
                                Text(text = "Swipe left to delete")
                                Spacer(Modifier.width(4.dp))
                                Icon(Icons.Default.Delete, contentDescription = "", tint = Color.Black)
                            }
                        }
                    },
                    directions = setOf(DismissDirection.EndToStart),
                    dismissThresholds = {FractionalThreshold(0.8f)},
                ) {
                    WishItem(wish) {
                        val id = wish.id
                        navController.navigate( "${Screen.AddScreen.route}/$id")
                    }
                }
            }
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
        elevation = 4.dp,
        backgroundColor = colorResource(id = R.color.green),
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
        ) {
            Text(
                wish.title, 
                fontWeight = FontWeight.ExtraBold,
                fontSize = 16.sp,
                color = colorResource(id = R.color.white),
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                wish.description,
                fontSize = 13.sp,
                color = colorResource(id = R.color.white),
            )
        }
    }
}