package com.hussein.jetpackcomposeexample.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun GradientButton(text:String, textColor: Color, gradient: Brush, onClick:()->Unit){
    Button(onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent
        ),
        contentPadding = PaddingValues()
    ) {
        Box(modifier = Modifier
            .background(gradient)
            .padding(horizontal = 16.dp, vertical = 8.dp), contentAlignment = Alignment.Center){
            Text(text = text, color = textColor)
        }
    }

}