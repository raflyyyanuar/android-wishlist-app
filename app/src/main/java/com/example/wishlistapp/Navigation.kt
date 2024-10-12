package com.example.wishlistapp

import androidx.compose.runtime.Composable
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
            HomeView()
        }
//        composable(Screen.CategoryDetailsScreen.route) {
//            // Get from the PREVIOUS backstack the value of "category" key
//            val category = navController
//                .previousBackStackEntry         // get the PREVIOUS backstack
//                ?.savedStateHandle              // through the saved state
//                ?.get<Category>("category")     // get the value
//                ?: Category("","","","")
//
//            CategoryDetailScreen(
//                category = category
//            )
//        }
    }
}