package com.example.wishlistapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun Navigation(
    viewModel: WishViewModel = viewModel(),
    navController: NavHostController = rememberNavController(),
) {
    NavHost(navController, Screen.HomeScreen.route) {
        composable(Screen.HomeScreen.route) {
            HomeView(
                viewModel = viewModel,
                navController = navController,
            )
        }
        composable(Screen.AddScreen.route) {
            viewModel.resetWishState()



            AddEditDetailView(
                id = 0L,
                viewModel = viewModel, 
                navController = navController 
            )
        }
    }
}