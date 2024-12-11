package com.parthika.examproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign

@Composable
fun AmountInputScreen(modifier: Modifier) {
    var inputAmount by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF002D3C)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
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

        Box(
            modifier = Modifier
                .background(Color.Gray)
                .padding(15.dp,5.dp,15.dp,5.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "BALANCE",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 14.sp
                    )
                )
                Text(
                    text = "$13,935",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "How much would you like to send?",
            style = TextStyle(
                color = Color.White,
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "$${if (inputAmount.isEmpty()) "0" else inputAmount}",
            style = TextStyle(
                color = Color.White,
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        )

        Spacer(modifier = Modifier.weight(1f))


        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val rows = listOf(
                listOf("1", "2", "3"),
                listOf("4", "5", "6"),
                listOf("7", "8", "9"),
                listOf(".", "0", "*")
            )

            rows.forEach { row ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    row.forEach { key ->
                        Box(
                            modifier = Modifier
                                .size(80.dp)
                                .clickable {
                                    inputAmount = when (key) {
                                        "*" -> if (inputAmount.isNotEmpty()) inputAmount.dropLast(1) else ""
                                        "." -> if (!inputAmount.contains(".")) inputAmount + "." else inputAmount
                                        else -> inputAmount + key
                                    }
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = key,
                                style = TextStyle(
                                    color = Color.White,
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                        }
                    }
                }
            }
        }

        if (inputAmount.isNotEmpty() && inputAmount.toDoubleOrNull() ?: 0.0 > 0.0) {
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {  },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00C781)),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 16.dp)
            ) {
                Text(
                    text = "Confirm",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}