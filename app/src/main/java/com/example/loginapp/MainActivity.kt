package com.example.loginapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.loginapp.ui.theme.LoginAppTheme
import com.example.loginapp.view.HomePage
import com.example.loginapp.view.LoginPage
import com.example.loginapp.view.Register

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginAppTheme {
                navigatePage()
            }
        }
    }
}

@Composable
fun navigatePage() {
    val navController  = rememberNavController()
    NavHost(navController= navController, startDestination = "login_Page",
        builder = {
            composable("login_Page", content = { LoginPage(navController= navController) })
            composable("home_Page", content = { HomePage(navController= navController) })
            composable("register_Page", content = { Register(navController= navController) })
        }
        )
}
