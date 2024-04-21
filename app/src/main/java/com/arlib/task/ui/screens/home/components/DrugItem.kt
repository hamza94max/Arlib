package com.arlib.task.ui.screens.home.components

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.arlib.task.domain.models.Drug
import com.arlib.task.navigation.DrugDetails

@Composable
fun DrugItem(drug: Drug, navController: NavController) {

    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth()
            .clickable {
                Log.d("hamzaLOO", "Click on drug $drug")
                navController.currentBackStackEntry?.savedStateHandle?.set(
                    key = "drug",
                    value = drug
                )
                navController.navigate(DrugDetails.route)
            },

        shape = MaterialTheme.shapes.medium,
        elevation = 4.dp,
        border = BorderStroke(1.dp, Color.LightGray),

        ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = drug.name.toString(),
                style = MaterialTheme.typography.h6,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Dose: ${drug.dose}",
                style = MaterialTheme.typography.body1,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Strength: ${drug.strength}",
                style = MaterialTheme.typography.body1,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview
@Composable
fun previewDrugItem() {
    val drug = Drug("aspirin", "1 tablet", "500 mg")

    //DrugItem(drug = drug)
}