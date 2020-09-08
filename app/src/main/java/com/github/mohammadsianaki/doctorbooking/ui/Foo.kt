package com.github.mohammadsianaki.doctorbooking.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.loadImageResource
import androidx.compose.ui.unit.dp
import com.github.mohammadsianaki.doctorbooking.R
import dev.chrisbanes.accompanist.coil.CoilImage

data class Recipe(
    @DrawableRes val imageResource: Int,
    val title: String,
    val ingredients: List<String>
)


private val recipeList = mutableListOf<Recipe>().apply {
    for (index in 0..100) {
        add(index, Recipe(R.drawable.header, "Cake$index", listOf("Bread", "Sugar2", "Apple")))
    }
}

@Composable
fun RecipeCard(recipe: Recipe) {
    val deferredImage = loadImageResource(
        id = R.drawable.header,
    )

    val imageModifier = Modifier.preferredHeight(150.dp).fillMaxWidth()
        .clip(shape = RoundedCornerShape(8.dp))
    deferredImage.resource.resource?.let {
        Image(
            asset = it,
            modifier = imageModifier
        )
    }

    Surface(
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp,
        modifier = Modifier.padding(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            val imageModifier = Modifier.preferredHeight(150.dp).fillMaxWidth()
                .clip(shape = RoundedCornerShape(8.dp))
            deferredImage.resource.resource?.let {
                Image(
                    asset = it,
                    modifier = imageModifier
                )
            }
            CoilImage(data = R.drawable.header)
            Spacer(modifier = Modifier.preferredHeight(16.dp))
            Text(text = recipe.title, style = MaterialTheme.typography.h6)
            for (ingredient in recipe.ingredients) {
                Text(text = ingredient, style = MaterialTheme.typography.body2)
            }
        }
    }
}

@Composable
fun RecipeList(recipeList: List<Recipe>) {
    LazyColumnFor(items = recipeList) { item ->
        RecipeCard(recipe = item)
    }
}