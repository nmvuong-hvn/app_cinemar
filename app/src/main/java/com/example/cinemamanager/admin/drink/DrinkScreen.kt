package com.example.cinemamanager.admin.drink

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.cinemamanager.R
import com.example.cinemamanager.components.CommonButton
import com.example.cinemamanager.components.CommonOutLineTextField
import com.example.cinemamanager.components.CommonSearch

@Composable
fun DrinkScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        CommonSearch(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            hint = "Ten"
        ) {

        }

    }
}

@Composable
fun DrinkItem(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(fraction = 0.3f)
            ) {
                Text(text = "Nuoc suoi", style = MaterialTheme.typography.titleSmall)
                Text(
                    text = "10 000 VND",
                    style = MaterialTheme.typography.titleSmall.copy(color = Color.Red)
                )
            }
            Column(
                modifier = Modifier.fillMaxWidth(fraction = 0.3f)
            ) {
                Text(text = "Nuoc suoi", style = MaterialTheme.typography.titleSmall)
                Text(
                    text = "10 000 VND",
                    style = MaterialTheme.typography.titleSmall.copy(color = Color.Red)
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Image(
                    painter = painterResource(
                        id = R.drawable.baseline_edit_note_24
                    ),
                    contentDescription = null,
                )
                Image(
                    painter = painterResource(
                        id =
                        R.drawable.baseline_delete_24
                    ),
                    contentDescription = null,
                )

            }
        }

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 4.dp),
            color = colorResource(id = R.color.bg_text_field)
        )
    }
}

@Composable
fun DrinkAddScreen(
    modifier: Modifier = Modifier,
    title: String = "",
    nameBtn : String ="",
    value: String = "",
    onValueChangeName: (String) -> Unit,
    onValueChangeLink: (String) -> Unit
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = title, style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(20.dp))
        CommonOutLineTextField(
            modifier = Modifier.fillMaxWidth(), value = value,
            onValueChange = { onValueChangeName(it) },
            hint = "Ten...",
            keyboardType = KeyboardType.Text
        )
        Spacer(modifier = Modifier.height(20.dp))
        CommonOutLineTextField(
            modifier = modifier.fillMaxWidth(), value = value,
            onValueChange = { onValueChangeLink(it) },
            hint = "Gia...",
            keyboardType = KeyboardType.Number
        )
        Spacer(modifier = Modifier.height(20.dp))
        CommonOutLineTextField(
            modifier = modifier.fillMaxWidth(), value = value,
            onValueChange = { onValueChangeLink(it) },
            hint = "So luong...",
            keyboardType = KeyboardType.Number
        )
        Spacer(modifier = Modifier.height(20.dp))
        CommonButton(
            nameBtn = nameBtn, modifier = Modifier
                .fillMaxWidth()
        )
    }

}

@Preview
@Composable
fun PreviewDrinkAddScreen() {
    DrinkAddScreen(title = "Them do an/ do uong", nameBtn = "Them", value = "", onValueChangeName = {}){

    }
}


@Preview
@Composable
fun PreviewDrinkScreen() {
    DrinkItem()
}