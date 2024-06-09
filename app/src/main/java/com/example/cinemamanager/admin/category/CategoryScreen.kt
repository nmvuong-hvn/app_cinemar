package com.example.cinemamanager.admin.category

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.example.cinemamanager.R
import com.example.cinemamanager.components.CommonButton
import com.example.cinemamanager.components.CommonOutLineTextField
import com.example.cinemamanager.components.CommonSearch

@Composable
fun CategoryScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize().padding(vertical = 16.dp),
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
fun CategoryAddAndEditItem(
    modifier: Modifier = Modifier,
    title: String = "",
    nameBtn : String ="",
    value: String = "",
    onValueChangeName: (String) -> Unit,
    onValueChangeLink: (String) -> Unit
) {
    Column(
        modifier = modifier.fillMaxWidth().padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = title, style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(20.dp))
        CommonOutLineTextField(modifier = Modifier.fillMaxWidth(), value = value,
            onValueChange = {onValueChangeName(it)},
            hint = "Ten the loai...",
            keyboardType = KeyboardType.Text)
        Spacer(modifier = Modifier.height(20.dp))
        CommonOutLineTextField(modifier = modifier.fillMaxWidth(),value = value,
            onValueChange = {onValueChangeLink(it)},
            hint = "Link anh...",
            keyboardType = KeyboardType.Text)
        Spacer(modifier = Modifier.height(20.dp))
        CommonButton(nameBtn = nameBtn, modifier = Modifier
            .fillMaxWidth())
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryItem(
    modifier: Modifier = Modifier,
    name: String,
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 3.dp
        ),
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .padding(horizontal = 8.dp),
        onClick = { /*TODO*/ }) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ConstraintLayout(
                modifier = Modifier.fillMaxWidth()
            ) {

                val (ivCategory, nameCategory, ivEdit, ivDel) = createRefs()

                AsyncImage(
                    model = "https://kinsta.com/wp-content/uploads/2021/02/what-is-a-url.jpg",
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .constrainAs(ivCategory) {
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                            start.linkTo(parent.start)
                        }
                )

                Text(text = name,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.constrainAs(nameCategory) {
                        top.linkTo(ivCategory.top)
                        bottom.linkTo(ivCategory.bottom)
                        start.linkTo(ivCategory.end, 8.dp)
                    }
                )

                Image(
                    painter = painterResource(
                        id = R.drawable.baseline_edit_note_24
                    ),
                    contentDescription = null,
                    modifier = Modifier.constrainAs(ivEdit) {
                        top.linkTo(ivCategory.top)
                        bottom.linkTo(ivCategory.bottom)
                        end.linkTo(ivDel.start, 5.dp)
                    }
                )
                Image(
                    painter = painterResource(
                        id =
                        R.drawable.baseline_delete_24
                    ), contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                        .constrainAs(ivDel) {
                            top.linkTo(ivCategory.top)
                            bottom.linkTo(ivCategory.bottom)
                            end.linkTo(parent.end)
                        }
                )

            }
        }
    }
}

@Preview("addItem")
@Composable
fun PreviewCategoryAddItem(){
    CategoryAddAndEditItem(
        title = "Them the loai",
        nameBtn = "Them the loai",
        onValueChangeName = {}) {
        
    }
}

@Preview("editItem")
@Composable
fun PreviewCategoryEditItem(){
    CategoryAddAndEditItem(
        title = "Chinh sua the loai",
        nameBtn = "Chinh sua ",
        onValueChangeName = {}) {

    }
}


@Preview("item")
@Composable
fun PreviewCategoryItem() {
    CategoryItem(name = "Lang man")
}

@Preview
@Composable
fun PreviewCategoryScreen() {
    CategoryScreen()
}

