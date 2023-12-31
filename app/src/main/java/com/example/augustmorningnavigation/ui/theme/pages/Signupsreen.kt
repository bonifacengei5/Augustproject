package com.example.augustmorningnavigation.ui.theme.pages

import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.augustmorningnavigation.data.AuthRepository
import com.example.augustmorningnavigation.navigation.ROUTE_SIGNUP
import com.example.augustmorningnavigation.ui.theme.AugustMorningNavigationTheme
import com.example.augustmorningnavigation.ui.theme.pages.about.AboutScreen
@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun SignupScreen(navHostController:NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = " login here",
            fontSize = 30.sp,
            fontFamily = FontFamily.Cursive,
            color = Color.Red,
            modifier = Modifier.padding(20.dp),
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline
        )
        var name by remember { mutableStateOf(TextFieldValue("")) }
        var email by remember { mutableStateOf(TextFieldValue("")) }
        var password by remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(
            value = name,
            onValueChange = {name = it},
            label = { Text(text = "Name*") } ,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text))
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            label = { Text(text = "Email*") } ,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email))
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = password,
            onValueChange = {password = it},
            label = { Text(text = "Password") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            //--------WRITE THE Singup HERE------//
            var authRepository = AuthRepository(navHostController)
            authRepository.signup(name.text,email.text,password.text)
        }) {
            Text(text = "Login")


        }

        Spacer(modifier = Modifier.height(20.dp))





    }

}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_NO)
@Composable
fun HomeScreenPreview() {
    AugustMorningNavigationTheme() {
        SignupScreen(rememberNavController())
    }

}