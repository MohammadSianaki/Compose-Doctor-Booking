package com.github.mohammadsianaki.doctorbooking.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = AppColors,
        typography = AppTypography,
        content = content
    )
}