package com.roberthmdz.jetpackcompose_login_ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.roberthmdz.jetpackcompose_login_ui.presentation.home.HomeScreen
import com.roberthmdz.jetpackcompose_login_ui.presentation.login.LoginScreen
import com.roberthmdz.jetpackcompose_login_ui.presentation.login.LoginViewModel
import com.roberthmdz.jetpackcompose_login_ui.presentation.navigation.Destinations
import com.roberthmdz.jetpackcompose_login_ui.presentation.registration.RegistrationScreen
import com.roberthmdz.jetpackcompose_login_ui.ui.theme.JetPackComposeLoginUITheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalAnimationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeLoginUITheme {
                val navController = rememberAnimatedNavController()
                BoxWithConstraints() {
                    AnimatedNavHost(
                        navController = navController,
                        startDestination = Destinations.Login.route
                    ) {

                        addLogin(navController)
                        addRegister(navController)
                        addHome()

                    }

                    
                }

            }
        }
    }
}

@ExperimentalAnimationApi
fun NavGraphBuilder.addLogin(
    navController: NavHostController
) {

    composable(
        route = Destinations.Login.route,
        enterTransition = {_, _ ->
            slideInHorizontally(
                initialOffsetX = {1000},
                animationSpec = tween(500)
            )
        },
        exitTransition = {_, _ ->
            slideOutHorizontally(
                targetOffsetX = {-1000},
                animationSpec = tween(500)
            )
        },
        popEnterTransition = {_, _ ->
            slideInHorizontally(
                initialOffsetX = {-1000},
                animationSpec = tween(500)
            )
        },
        popExitTransition = {_, _ ->
            slideOutHorizontally(
                targetOffsetX = {1000},
                animationSpec = tween(500)
            )
        },

    ) {
        val viewModel: LoginViewModel = hiltViewModel()
        LoginScreen(
            state = viewModel.state.value,
            onLogin = viewModel::login,
            onNavigateToRegister = {
                navController.navigate(Destinations.Register.route)
            },
            onDismissDialog = viewModel::hideErrorDialog

        )
    }
}

@ExperimentalAnimationApi
fun NavGraphBuilder.addRegister(
    navController: NavHostController
) {

    composable(
        route = Destinations.Register.route,
        enterTransition = {_, _ ->
            slideInHorizontally(
                initialOffsetX = {1000},
                animationSpec = tween(500)
            )
        },
        exitTransition = {_, _ ->
            slideOutHorizontally(
                targetOffsetX = {-1000},
                animationSpec = tween(500)
            )
        },
        popEnterTransition = {_, _ ->
            slideInHorizontally(
                initialOffsetX = {-1000},
                animationSpec = tween(500)
            )
        },
        popExitTransition = {_, _ ->
            slideOutHorizontally(
                targetOffsetX = {1000},
                animationSpec = tween(500)
            )
        },
        ) {
        RegistrationScreen()
    }
}

@ExperimentalAnimationApi
fun NavGraphBuilder.addHome() {

    composable(
        route = Destinations.Home.route,
        enterTransition = {_, _ ->
            slideInHorizontally(
                initialOffsetX = {1000},
                animationSpec = tween(500)
            )
        },
        exitTransition = {_, _ ->
            slideOutHorizontally(
                targetOffsetX = {-1000},
                animationSpec = tween(500)
            )
        },
        popEnterTransition = {_, _ ->
            slideInHorizontally(
                initialOffsetX = {-1000},
                animationSpec = tween(500)
            )
        },
        popExitTransition = {_, _ ->
            slideOutHorizontally(
                targetOffsetX = {1000},
                animationSpec = tween(500)
            )
        },
    ) {
        HomeScreen("", "")
    }
}


