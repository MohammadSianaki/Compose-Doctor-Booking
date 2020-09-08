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
fun SectionTitle(text: String, modifier: Modifier = Modifier) {
    ProvideEmphasis(emphasis = EmphasisAmbient.current.high) {
        Text(
            modifier = Modifier.padding(16.dp).then(modifier),
            text = text, style = TextStyle(
                color = Color(0xDD000000).copy(alpha = 0.8f),
                fontSize = 25.sp,
                fontWeight = FontWeight.SemiBold
            )
        )
    }
}