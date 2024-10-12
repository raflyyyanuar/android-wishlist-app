package com.example.wishlistapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.wishlistapp.data.Wish

@Composable
fun AddEditDetailView(
    title: String,
    viewModel: WishViewModel,
    navController: NavHostController
) {
    Scaffold(
        topBar = {
            AppBar(
                title = title,
                onBackNavClick = {
                    navController.navigate(Screen.HomeScreen.route)
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .wrapContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Spacer(modifier = Modifier.height(10.dp))

            // Title
            WishTextField(
                label = "Title",
                value = viewModel.wishTitleState,
                onValueChange = { it ->
                    viewModel.onWishTitleChange(it)
                }
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Description
            WishTextField(
                label = "Description",
                value = viewModel.wishDescriptionState,
                onValueChange = { it ->
                    viewModel.onWishDescriptionChange(it)
                }
            )

            Spacer(modifier = Modifier.height(10.dp))

            Button(onClick = {
                if(viewModel.wishTitleState.isNotEmpty() &&
                    viewModel.wishDescriptionState.isNotEmpty()
                    ) {
                    // TODO UpdateWish
                }
                else {
                    // TODO AddWish
                }
            }) {
                Text(
                    title,
                    fontSize = 18.sp,
                )
            }
        }
    }
}

@Composable
fun WishTextField(
    label : String,
    value: String,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(
                label,
                color = colorResource(id = R.color.black)
            )
        },
        modifier = Modifier
            .fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            // text
            textColor = colorResource(id = R.color.black),

            // border
            focusedBorderColor = colorResource(id = R.color.black),
            unfocusedBorderColor = colorResource(id = R.color.black),

            // label
            focusedLabelColor = colorResource(id = R.color.black),
            unfocusedLabelColor = colorResource(id = R.color.black),

            // cursor
            cursorColor = colorResource(id = R.color.black),
        )
    )
}

@Preview(showBackground = true, backgroundColor = 0x000000)
@Composable
fun WishTextFieldPreview() {
    WishTextField(label = "This is a label", value = "This is a value") {
        
    }
}