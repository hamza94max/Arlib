package com.arlib.task.ui.login

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.arlib.task.R
import com.arlib.task.components.CustomDefaultBtn
import com.arlib.task.components.CustomTextField

@Composable
fun LoginScreen(
    navController: NavController
) {

    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(50.dp))

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(R.string.login),
                color = Color.Gray,
                fontSize = 18.sp
            )
        }
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = stringResource(R.string.welcome_back),
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(R.string.signin_with_username_and_pass),
            color = Color.Gray,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(50.dp))
        CustomTextField(
            trailingIcon = R.drawable.mail,
            label = stringResource(R.string.username),
            keyboardType = KeyboardType.Email,
            visualTransformation = VisualTransformation.None,
            onChange = { newEmail -> email = newEmail }
        )
        Spacer(modifier = Modifier.height(20.dp))
        CustomTextField(
            trailingIcon = R.drawable.lock,
            label = stringResource(R.string.password),
            keyboardType = KeyboardType.Password,
            visualTransformation = PasswordVisualTransformation(),
            onChange = { newPass -> password = newPass }
        )
        Spacer(modifier = Modifier.height(10.dp))

        CustomDefaultBtn(shapeSize = 50f, btnText = stringResource(R.string.login)) {

        }
    }
}
