package com.github.mohammadsianaki.doctorbooking.ui.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.github.mohammadsianaki.doctorbooking.ui.theme.AppTheme

@Composable
fun Search(query: TextFieldValue) {
    var queryState by remember { mutableStateOf(query) }
    SearchBox(
        queryState = queryState,
        onValueChanged = {
            queryState = it
        },
        modifier = Modifier.padding(16.dp)
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun SearchBox(
    queryState: TextFieldValue,
    onValueChanged: (TextFieldValue) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(modifier = modifier, color = Color(0xffEFEFEF), shape = RoundedCornerShape(10.dp)) {
        Stack(Modifier.fillMaxSize()) {
            if (queryState.text.isEmpty()) {
                SearchHint()
            }
            Row(Modifier.preferredHeightIn(56.dp).padding(horizontal = 16.dp)) {
                Icon(
                    Icons.Default.Search,
                    modifier = Modifier.wrapContentWidth().gravity(Alignment.CenterVertically)
                        .padding(end = 8.dp)
                )

                BaseTextField(
                    value = queryState,
                    onValueChange = { onValueChanged.invoke(it) },
                    textStyle = currentTextStyle(),
                    imeAction = ImeAction.Search,
                    onImeActionPerformed = { /* todo */ },
                    modifier = Modifier.weight(3f).gravity(Alignment.CenterVertically)
                )
            }
        }
    }
}

@Composable
private fun SearchHint() {
    Row(
        verticalGravity = Alignment.CenterVertically,
        modifier = Modifier.fillMaxSize().preferredHeightIn(56.dp).padding(horizontal = 16.dp)
    ) {
        Icon(
            asset = Icons.Outlined.Search,
            tint = Color(0xFF9E9E9E)
        )
        Spacer(Modifier.preferredWidth(8.dp))
        Text(
            text = "Search",
            color = Color(0xFF9E9E9E)
        )
    }
}

@ExperimentalFoundationApi
@Preview
@Composable
fun SearchBoxPreview() {
    AppTheme {
        SearchBox(queryState = TextFieldValue("Mohammad"), {})
    }
}