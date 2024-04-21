package com.arlib.task.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.arlib.task.domain.models.Drug
import com.arlib.task.ui.screens.drugDetails.DrugDetailsScreen
import com.arlib.task.ui.screens.home.HomeScreen
import com.arlib.task.ui.screens.login.LoginScreen


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
                backStackEntry.arguments?.getString("username"), navController = navHostController
            )
        }

        composable(route = DrugDetails.route) {
            val result =
                navHostController.previousBackStackEntry?.savedStateHandle?.get<Drug>("drug")
            Log.i("hamzaLOOK", "resutl is " + result.toString())
            result?.let { it1 -> DrugDetailsScreen(it1) }
        }


    }
}