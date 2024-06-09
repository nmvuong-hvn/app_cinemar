package com.example.cinemamanager.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.example.cinemamanager.R

@Composable
fun CommonButton(
    modifier: Modifier = Modifier,
    nameBtn: String = "",
    backgroundColor: Color = colorResource(id = R.color.bg_button)
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(color = backgroundColor, shape = RoundedCornerShape(10.dp))
            .padding(vertical = 16.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = nameBtn, style = MaterialTheme.typography.titleSmall.copy(
                fontFamily = FontFamily(
                    Font(
                        R.font.inter_semibold
                    )
                ),
                color = Color.White
            )
        )
    }
}