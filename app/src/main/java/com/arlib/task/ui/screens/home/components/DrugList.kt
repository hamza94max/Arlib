package com.arlib.task.ui.screens.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.arlib.task.domain.models.Drug

@Composable
fun DrugList(
    drugs: List<Drug>,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        drugs.forEach { drug ->
            DrugItem(drug = drug, navController)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

