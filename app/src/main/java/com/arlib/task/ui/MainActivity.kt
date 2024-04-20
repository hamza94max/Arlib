package com.arlib.task.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.arlib.task.navigation.AppNavHost
import com.arlib.task.ui.theme.ArlibTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArlibTheme {
                ShowScreen()
            }
        }
    }
}

@Composable
private fun ShowScreen(
    modifier: Modifier = Modifier,
) {
    // A surface container using the 'background' color from the theme
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val navHostController = rememberNavController()
        Scaffold() { paddingValues ->
            AppNavHost(
                navHostController = navHostController,
                modifier = Modifier.padding(paddingValues)
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArlibTheme {
        ShowScreen()
    }
}