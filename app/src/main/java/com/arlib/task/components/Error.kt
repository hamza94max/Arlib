package com.arlib.task.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun ErrorText(
    message: String,
    modifier: Modifier = Modifier
) {
    var showSnackbar by remember {
        mutableStateOf(true)
    }
    LaunchedEffect(key1 = showSnackbar) {
        if (showSnackbar) {
            delay(2000)
            showSnackbar = false

        }
    }
    if (showSnackbar) {
        Snackbar(
            modifier = modifier.padding(16.dp),
            contentColor = MaterialTheme.colorScheme.primary,
            shape = MaterialTheme.shapes.medium
        ) {
            Text(
                text = message,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ErrorPreview() {
    ErrorText(message = "Error")
}