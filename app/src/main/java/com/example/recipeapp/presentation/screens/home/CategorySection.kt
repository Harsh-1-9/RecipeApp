package com.example.recipeapp.presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.RestaurantMenu
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.recipeapp.ui.theme.myOrange
import java.util.logging.Filter

@Composable
fun CategorySection(
    categories: List<String>,
    selected: String,
    onSelected: (String) -> Unit,
) {
    Column() {
        SectionHeader(title = "Categories",
            icon = Icons.Default.Restaurant,
        )
        Spacer(modifier = Modifier.height(8.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(categories){ category ->
                val isSelected = selected == category
                FilterChip(
                    selected = isSelected,
                    onClick = { onSelected(category) },
                    label = { Text(
                        text = category,
                        fontWeight = if(isSelected) FontWeight.SemiBold else FontWeight.Normal
                    )
                    },
                    shape = RoundedCornerShape(16.dp),
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = myOrange,
                        selectedLabelColor = Color.White,
                        labelColor = Color.DarkGray,
                        containerColor = Color.White
                    ),
                    border = null
                )
            }
        }
    }
}