package com.arlib.task.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.arlib.task.ui.home.HomeScreen
import com.arlib.task.ui.login.LoginScreen


@Composable
fun AppNavHost(
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    NavHost(
        navController = navHostController,
        startDestination = Login.route,
        modifier = modifier
    ) {
        composable(route = Login.route) {
            LoginScreen(navController = navHostController)
        }

        composable(route = "${Home.route}/{username}") { backStackEntry ->
            HomeScreen(
                navController = navHostController,
                backStackEntry.arguments?.getString("username")
            )
        }


    }
}