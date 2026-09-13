package com.example.recipeapp.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recipeapp.presentation.viewmodels.HomeViewModel
import com.example.recipeapp.ui.theme.myOrange

@Composable
fun ErrorMessage(
    errorMessage : String?,
    onRetry : () -> Unit,
) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        ) {
        Text(text = errorMessage ?: "",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = myOrange,
            textAlign = TextAlign.Center,
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick =  onRetry,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = myOrange,
                contentColor = Color.White
            )
        ) {
            Text(text = "Retry",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}