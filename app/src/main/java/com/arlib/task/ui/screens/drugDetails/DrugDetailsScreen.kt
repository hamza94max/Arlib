package com.arlib.task.ui.screens.drugDetails

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.arlib.task.domain.models.Drug

@Composable
fun DrugDetailsScreen(
    drug: Drug
) {


    Log.i("hamzaLO", "drugDetailsScreen: $drug")
    Box(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(16.dp))
        Card(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .fillMaxWidth(),

            shape = MaterialTheme.shapes.medium,
            elevation = 4.dp,
            border = BorderStroke(1.dp, Color.LightGray)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                androidx.compose.material.Text(
                    text = drug.name,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                androidx.compose.material.Text(
                    text = "Dose: ${drug.dose}",
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                androidx.compose.material.Text(
                    text = "Strength: ${drug.strength}",
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

    }

}