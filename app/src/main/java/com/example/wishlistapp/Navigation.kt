package com.example.wishlistapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument


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
        composable( "${Screen.AddScreen.route}/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.LongType
                    defaultValue = 0L
                    nullable = false
                },
            )
        ) { entry ->

//            viewModel.resetWishState()
            val id = if(entry.arguments != null) entry.arguments!!.getLong("id") else 0L

            AddEditDetailView(
                id = id,
                viewModel = viewModel, 
                navController = navController 
            )
        }
    }
}