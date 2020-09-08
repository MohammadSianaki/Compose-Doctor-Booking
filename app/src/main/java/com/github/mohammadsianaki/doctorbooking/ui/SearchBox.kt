package com.github.mohammadsianaki.doctorbooking.ui

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredHeightIn
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview

@Composable
@Preview
fun SearchBox(modifier: Modifier = Modifier) {
    Surface(modifier = modifier, color = Color(0xffEFEFEF), shape = RoundedCornerShape(10.dp)) {
        Row(Modifier.preferredHeightIn(48.dp).padding(horizontal = 16.dp)) {
            Icon(
                Icons.Default.Search,
                modifier = Modifier.wrapContentWidth().gravity(Alignment.CenterVertically)
                    .padding(end = 8.dp)
            )
            Text(
                color = Color(0xFF9E9E9E),
                text = "Search",
                modifier = Modifier.weight(3f).gravity(Alignment.CenterVertically)
            )
        }
    }
}