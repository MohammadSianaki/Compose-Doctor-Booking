package com.github.mohammadsianaki.doctorbooking.ui.components

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.padding
import androidx.compose.material.EmphasisAmbient
import androidx.compose.material.ProvideEmphasis
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EmphasizedText(
    text: String,
    modifier: Modifier? = null,
    textStyle: TextStyle? = null
) {
    ProvideEmphasis(emphasis = EmphasisAmbient.current.high) {
        Text(
            modifier = modifier ?: Modifier.padding(16.dp),
            text = text, style = textStyle ?: TextStyle(
                color = Color(0xDD000000).copy(alpha = 0.8f),
                fontSize = 25.sp,
                fontWeight = FontWeight.SemiBold
            )
        )
    }
}