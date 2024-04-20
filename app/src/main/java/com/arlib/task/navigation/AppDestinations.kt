package com.arlib.task.navigation

interface AppDestinations {
    val route: String
}

object Login : AppDestinations {
    override val route = "login"
}

object Home : AppDestinations {
    override val route = "home"
}