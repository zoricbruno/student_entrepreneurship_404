package hr.ferit.up404.laughly.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import hr.ferit.up404.laughly.ui.Screen

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable(Screen.Laugh.route) { LaughScreen(navController) }
        composable(Screen.Inspire.route) { InspireScreen(navController) }
        composable(Screen.Play.route) { PlayScreen(navController) }
    }
}
