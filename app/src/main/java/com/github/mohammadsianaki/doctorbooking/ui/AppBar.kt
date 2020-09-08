package com.github.mohammadsianaki.doctorbooking.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AppBar() {
    TopAppBar(
        modifier = Modifier.padding(0.dp),
        elevation = 0.dp,
        backgroundColor = Color.White
    ) {}
}