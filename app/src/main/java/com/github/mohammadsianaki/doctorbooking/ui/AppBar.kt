package com.github.mohammadsianaki.doctorbooking.ui

import androidx.compose.foundation.Icon
import androidx.compose.foundation.layout.padding
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AppBar(showBackButton: Boolean = false) {
    TopAppBar(
        modifier = Modifier.padding(0.dp),
        elevation = 0.dp,
        backgroundColor = Color.White,
    ) {
        IconButton(onClick = {}) {
            Icon(asset = Icons.Default.ArrowBack)
        }
    }
}