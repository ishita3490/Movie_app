package com.example.movie_app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movie_app.screens.DetailedScreen.DetailsScreen
import com.example.movie_app.screens.home.HomeScreen


@Composable
fun MovieNaviagtion(){
    val navController = rememberNavController()
    NavHost(navController = navController ,
        startDestination = MovieScreens.HomeScreen.name){

        composable(MovieScreens.HomeScreen.name){
            // here we pass where this should lead us to
            HomeScreen(navController = navController)
        }

        //www.google.com/detail-screen/id=34
        composable(MovieScreens.DetailsScreen.name+"/{movie}",
                arguments = listOf(navArgument(name = "movie"){type = NavType.StringType})
        ){
            backStackEntry ->
            DetailsScreen(navController = navController,
                backStackEntry.arguments?.getString("movie"))
        }
    }
}