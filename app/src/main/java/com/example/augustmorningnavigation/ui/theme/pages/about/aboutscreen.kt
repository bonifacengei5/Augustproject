package com.example.augustmorningnavigation.ui.theme.pages.about

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.augustmorningnavigation.ui.theme.AugustMorningNavigationTheme

@Composable
fun AboutScreen(navController: NavHostController) {
    Text(text = "Welcome to aboutpage")

}
@Preview(showBackground = true,uiMode = UI_MODE_NIGHT_NO)
@Composable
fun AboutScreenPreview() {
    AugustMorningNavigationTheme() {
        AboutScreen(rememberNavController())

    }

}