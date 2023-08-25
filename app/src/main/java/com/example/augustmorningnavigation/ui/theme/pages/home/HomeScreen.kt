package com.example.augustmorningnavigation.ui.theme.pages.home

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.augustmorningnavigation.ui.theme.AugustMorningNavigationTheme
import com.example.augustmorningnavigation.ui.theme.pages.about.AboutScreen

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Welcome to home page")

        Button(onClick = { /*TODO*/ }) {
            Text(text = "Add products")
        }

        Button(onClick = { /*TODO*/ }) {
            Text(text = "View products")
        }
        
    }

}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_NO)
@Composable
fun HomeScreenPreview() {
    AugustMorningNavigationTheme() {
        HomeScreen(rememberNavController())
    }


}
