package com.github.mohammadsianaki.doctorbooking.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.ContentGravity
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.github.mohammadsianaki.doctorbooking.data.DataFactory


data class DoctorModel(
    val name: String,
    val speciality: String,
    @DrawableRes val profile: Int,
    val telephone: String
)

@Composable
fun DoctorsList(doctors: List<DoctorModel>) {
    LazyColumnFor(items = doctors, modifier = Modifier.fillMaxWidth().padding(16.dp)) { item ->
        DoctorCard(item)
    }
}

@Composable
fun DoctorCard(doctor: DoctorModel) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        backgroundColor = Color(0xffFFEEE0)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalGravity = ContentGravity.CenterVertically
        ) {
            Image(
                asset = imageResource(id = doctor.profile),
                modifier = Modifier.preferredSize(56.dp).padding(horizontal = 8.dp)
            )
            Column(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            ) {
                Text(
                    text = doctor.name, style = TextStyle(
                        color = Color(0xffFC9535),
                        fontSize = 19.sp
                    )
                )
                Text(
                    text = doctor.speciality, style = TextStyle(
                        fontSize = 15.sp
                    )
                )
            }
            Button(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                onClick = {},
                backgroundColor = Color(0xffFBB97C)
            ) {
                Text(
                    text = "Call", style = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.W500,
                        fontSize = 13.sp
                    )
                )
            }
        }
    }
}


@Composable
@Preview
fun DoctorCardPreview(doctor: DoctorModel = DataFactory.getDoctors()[0]) {
    MaterialTheme {
        DoctorCard(doctor = doctor)
    }
}