package com.roberthmdz.jetpackcompose_login_ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.roberthmdz.jetpackcompose_login_ui.presentation.login.LoginScreen
import com.roberthmdz.jetpackcompose_login_ui.ui.theme.JetPackComposeLoginUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeLoginUITheme {
               LoginScreen()
            }
        }
    }
}
