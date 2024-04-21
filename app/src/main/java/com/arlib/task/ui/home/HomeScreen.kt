package com.arlib.task.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.arlib.task.components.ErrorText
import com.arlib.task.components.Loading
import com.arlib.task.domain.models.DrugsResponse
import com.arlib.task.ui.home.components.DrugList
import com.arlib.task.utils.Resource
import com.arlib.task.utils.Utils.getGreeting

@Composable
fun HomeScreen(
    navController: NavController,
    username: String?,
    drugsViewModel: DrugsViewModel = hiltViewModel(),
) {

    val drugsState by drugsViewModel.drugsFlow.collectAsState(initial = Resource.Idle)

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "${getGreeting()}, $username !",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(8.dp)
        )

        when (drugsState) {
            is Resource.Idle -> {}

            is Resource.Loading -> {
                Loading()
            }
            is Resource.Error -> {
                ErrorText(message = "Error: ${(drugsState as Resource.Error).exception.message}")
            }
            is Resource.Success<*> -> {
                val drugs = (drugsState as Resource.Success).data.drugs
                if (drugs.isNullOrEmpty()) {
                    Text(text = "No drugs found")
                } else {
                    DrugList((drugsState as Resource.Success<DrugsResponse>).data.drugs)
                }
            }
        }
    }
}