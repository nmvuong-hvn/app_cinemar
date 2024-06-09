package com.example.cinemamanager.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.cinemamanager.R
import com.example.cinemamanager.components.CommonButton
import com.example.cinemamanager.components.CommonOutLineTextField

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier
){
    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var confirmPassword by remember {
        mutableStateOf("")
    }


    var isSeenPassword by remember {
        mutableStateOf(false)
    }

    ConstraintLayout(
        modifier = modifier.fillMaxSize()
    ) {
        val (container, footer) = createRefs()
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .constrainAs(container) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                modifier = Modifier
                    .size(240.dp)
                    .padding(vertical = 16.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(text = "Create your Account", style = MaterialTheme.typography.titleMedium)
            }

            CommonOutLineTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                value = email,
                onValueChange = { email = it },
                hint = "Email", keyboardType = KeyboardType.Email
            )
            CommonOutLineTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                value = password,
                onValueChange = { password = it },
                hint = "Password",
                onSeenPassword = {
                    isSeenPassword = !isSeenPassword
                },
                keyboardType = KeyboardType.Password,
                isHidden = isSeenPassword,
                isPassword = true
            )
            CommonOutLineTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                hint = "Confirm Password",
                onSeenPassword = {
                    isSeenPassword = !isSeenPassword
                },
                keyboardType = KeyboardType.Password,
                isHidden = isSeenPassword,
                isPassword = true
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = "Forget Password?",
                    style = MaterialTheme.typography.titleSmall.copy(fontSize = 14.sp)
                )
            }

            CommonButton(nameBtn = "Sign Up")

        }
        Text(
            modifier = Modifier.constrainAs(footer) {
                bottom.linkTo(parent.bottom, 38.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            text = "If you have an account. Please sign in",
            style = MaterialTheme.typography.titleSmall
        )
    }

}

@Preview
@Composable
fun PreviewSignUp(){
    SignUpScreen()
}