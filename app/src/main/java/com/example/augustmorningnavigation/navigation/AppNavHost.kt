package com.example.augustmorningnavigation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.augustmorningnavigation.ui.theme.pages.login.Loginscreen
import com.example.augustmorningnavigation.ui.theme.pages.SignupScreen
import com.example.augustmorningnavigation.ui.theme.pages.about.AboutScreen
import com.example.augustmorningnavigation.ui.theme.pages.home.HomeScreen
import com.example.augustmorningnavigation.ui.theme.pages.products.AddProductsScreen


@Composable
fun AppNavHost(modifier: Modifier=Modifier,
       navHostController: NavHostController = rememberNavController(),
       starDestination:String = ROUTE_LOGIN){
    NavHost(
        modifier = modifier,

        navController = navHostController,
        startDestination = starDestination){
        composable(ROUTE_LOGIN){
            Loginscreen(navHostController)

        }
        composable(ROUTE_SIGNUP){
            SignupScreen(navHostController)

        }
        composable(ROUTE_HOME){
            HomeScreen(navHostController)

        }
        composable(ROUTE_ABOUT){
            AboutScreen(navHostController)


        }
        composable(ROUTE_ADD_PRODUCTS) {
            AddProductsScreen(navHostController)
        }
        composable(ROUTE_VIEW_PRODUCTS) {
            //Design the view products screen to use here
        }



    }


}
