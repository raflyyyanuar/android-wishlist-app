package com.example.wishlistapp

import android.widget.Toast
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
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.wishlistapp.data.Wish
import kotlinx.coroutines.launch

@Composable
fun AddEditDetailView(
    id: Long,
    viewModel: WishViewModel,
    navController: NavHostController
) {
    val snackMessage = remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()

    if(id != 0L) {
        val wish = viewModel.getWishById(id).collectAsState(initial = Wish())
        viewModel.onWishChange(wish.value)
    }
    else {
        viewModel.resetWishState()
    }

    Scaffold(
        topBar = {
            AppBar(
                title = if(id == 0L) "Add Wish" else "Edit Wish",
                onBackNavClick = {
                    navController.navigateUp()
                }
            )
        },
        scaffoldState = scaffoldState,
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
                    // TODO AddWish
                    if(id == 0L) {
                        viewModel.addWish(
                            Wish(
                                title = viewModel.wishTitleState.trim(),
                                description = viewModel.wishDescriptionState.trim(),
                            )
                        )

                        snackMessage.value = "Successfully added a wish!"
                    }
                    // TODO UpdateWish
                    else {
                        viewModel.updateWish(
                            Wish(
                                title = viewModel.wishTitleState.trim(),
                                description = viewModel.wishDescriptionState.trim(),
                            )
                        )
                    }

                }
                else {
                    snackMessage.value = "Title or description can not be empty!"
                }

                scope.launch {
                    navController.navigateUp()
                }

            }) {
                Text(
                    text = if(id == 0L) "Add Wish" else "Edit Wish",
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
    val isTitle = label.contentEquals("title", true)
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(
                label,
                color = colorResource(id = R.color.gray)
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            // text
            textColor = colorResource(id = R.color.white),

            focusedBorderColor = colorResource(id = R.color.white),
            focusedLabelColor = colorResource(id = R.color.white),

            unfocusedBorderColor = colorResource(id = R.color.gray),
            unfocusedLabelColor = colorResource(id = R.color.gray),

            cursorColor = colorResource(id = R.color.gray),
            backgroundColor = colorResource(id = R.color.dark_gray),
        ),
        textStyle = TextStyle(
            fontSize = if(isTitle) 16.sp else 13.sp,
            fontWeight = if(isTitle) FontWeight.ExtraBold else null
        ),
    )
}

@Preview(showBackground = true, backgroundColor = 0x000000)
@Composable
fun WishTextFieldPreview() {
    WishTextField(label = "This is a label", value = "This is a value") {
        
    }
}