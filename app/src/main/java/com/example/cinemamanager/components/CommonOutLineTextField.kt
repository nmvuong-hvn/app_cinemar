@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.cinemamanager.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.cinemamanager.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommonOutLineTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    hint: String = "",
    keyboardType: KeyboardType,
    shape: Shape = RoundedCornerShape(10.dp),
    colorText: Color = colorResource(id = R.color.black),
    onSeenPassword: (() -> Unit)? = null,
    isPassword: Boolean = false,
    isHidden: Boolean = false
) {
    OutlinedTextField(
        modifier = modifier,
        value = value, onValueChange = { onValueChange(it) },
        placeholder = { Text(text = hint, style = MaterialTheme.typography.titleSmall) },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = colorResource(id = R.color.bg_text_field),
            unfocusedTextColor = colorText,
            focusedTextColor = colorText,
            disabledTextColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = {
            if (isPassword) {
                IconButton(onClick = {

                    if (onSeenPassword != null) {
                        onSeenPassword()
                    }
                }) {
                    Icon(
                        imageVector = if (isHidden) Icons.Default.PlayArrow else Icons.Default.Person,
                        contentDescription = null
                    )
                }
            }
        },
        shape = shape
    )
}