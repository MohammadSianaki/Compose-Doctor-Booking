package com.github.mohammadsianaki.doctorbooking.ui

import androidx.compose.foundation.Box
import androidx.compose.foundation.ContentGravity
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.foundation.layout.preferredWidth
import androidx.compose.foundation.lazy.LazyRowFor
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.github.mohammadsianaki.doctorbooking.data.DataFactory
import com.github.mohammadsianaki.doctorbooking.model.SpecialityModel


@Composable
fun SpecialityList(specialityModels: List<SpecialityModel>) {
    Box(Modifier.preferredHeight(250.dp)) {
        LazyRowFor(items = specialityModels) { item ->
            SpecialityCard(specialityModel = item)
        }
    }
}


@Composable
fun SpecialityCard(specialityModel: SpecialityModel) {
    Card(
        shape = RoundedCornerShape(24.dp),
        backgroundColor = specialityModel.backgroundColor,
        modifier = Modifier.padding(16.dp).preferredWidth(150.dp),
        elevation = 4.dp
    ) {
        Box(
            modifier = Modifier.padding(horizontal = 16.dp),
            gravity = ContentGravity.TopStart
        ) {
            Text(
                modifier = Modifier.padding(top = 16.dp),
                text = specialityModel.speciality,
                style = TextStyle(color = Color.White, fontSize = 20.sp)
            )
            Text(
                modifier = Modifier.padding(top = 8.dp),
                text = "${specialityModel.numberOfDoctors} Doctors",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 13.sp
                )
            )
            Image(
                modifier = Modifier.preferredHeight(160.dp),
                asset = imageResource(id = specialityModel.image),
                contentScale = ContentScale.Fit,
            )
        }

    }
}

@Composable
@Preview
fun SpecialityCardPreview(specialityModel: SpecialityModel = DataFactory.getSpeciality()[0]) {
    MaterialTheme {
        SpecialityCard(specialityModel = specialityModel)
    }
}