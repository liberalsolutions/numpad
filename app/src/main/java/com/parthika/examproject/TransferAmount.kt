package com.parthika.examproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun TransferAmount(modifier: Modifier = Modifier) {

    val balance = remember {
        mutableStateOf(0)
    }

    val amount = remember { 
        mutableStateOf(0)
    }

    Column(modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround) {

        Box(modifier = Modifier.fillMaxWidth()
            .padding(20.dp)) {
            Image(
                painter = painterResource(R.drawable.shape),
                contentDescription = "Close",
                alignment = Alignment.TopEnd,
                modifier = Modifier.fillMaxWidth()
                    .size(16.dp)
                    .clickable {

                }
            )
        }

        Box (
            modifier.background(Color.Gray)
                .padding(20.dp)
        ){
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    text = "Balance"
                )
                Text(
                    text = "$ ${balance.value}"
                )
            }
        }

        Text(
            text = "How much would you like to send?"
        )

        Text(
            text = "$ ${amount.value}"
        )

        CustomKeyboard()


    }
}


@Composable
fun CustomKeyboard() {
    val inputValue = remember {
        mutableStateOf("")
    }
    val scrollState = rememberScrollState()

    MyCustomKeyboard(
        inputValue,
        scrollState,
        onClick = {
            digit ->
            inputValue.value + digit
        }
    )
}

@Composable
fun MyCustomKeyboard(inputValue: MutableState<String>, scrollState: ScrollState, onClick:(digit:Char)-> Unit) {

    Column {
        Spacer(
            modifier = Modifier.height(60.dp)
        )

        Row (
            modifier = Modifier.fillMaxWidth()
        ){
            NumberButton(1, onClick = onClick, modifier =Modifier.weight(1f))
            NumberButton(2, onClick = onClick, modifier =Modifier.weight(1f))
            NumberButton(3, onClick = onClick, modifier =Modifier.weight(1f))
        }

        Row (
            modifier = Modifier.fillMaxWidth()
        ){
            NumberButton(4, onClick = onClick, modifier =Modifier.weight(1f))
            NumberButton(5, onClick = onClick, modifier =Modifier.weight(1f))
            NumberButton(6, onClick = onClick, modifier =Modifier.weight(1f))
        }

        Row (
            modifier = Modifier.fillMaxWidth()
        ){
            NumberButton(0, onClick = onClick, modifier =Modifier.weight(1f))
            NumberButton(9, onClick = onClick, modifier =Modifier.weight(1f))
            NumberButton(0, onClick = onClick, modifier =Modifier.weight(1f))
        }
    }
}

@Composable
fun NumberButton(number: Int, onClick: (digit: Char) -> Unit, modifier: Modifier) {
    OutlinedButton(
        onClick = {
//            @OptIn(ExperimentalStdlibApi::class.java)
            onClick(number.toChar())
        },
        modifier = modifier
            .padding(4.dp)
            .height(70.dp)
    ) {
        Text(
            text = "$number",
            fontSize = 30.sp
        )
    }
}
