package com.arlib.task.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun CustomTextField(
    trailingIcon: Int,
    label: String,
    keyboardType: KeyboardType,
    visualTransformation: VisualTransformation,
    onChange: (TextFieldValue) -> Unit
) {
    var text by remember {
        mutableStateOf(TextFieldValue(""))
    }

    OutlinedTextField(
        value = text,
        onValueChange = { newText ->
            text = newText
            onChange(newText)
        },
        label = { Text(text = label) },
        shape = RoundedCornerShape(1.dp),
        trailingIcon = {
            Icon(
                painter = painterResource(id = trailingIcon),
                contentDescription = "TextField Description"
            )
        },
        singleLine = true,
        visualTransformation = visualTransformation,
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = keyboardType),
        keyboardActions = KeyboardActions(
            onNext = {}
        ),
        modifier = Modifier.fillMaxWidth()
    )
}