package com.github.mohammadsianaki.doctorbooking.ui.dashboard

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.ContentGravity
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.mohammadsianaki.doctorbooking.model.DoctorModel
import com.github.mohammadsianaki.doctorbooking.util.Screen


@Composable
fun DoctorsList(doctors: List<DoctorModel>, onItemClicked: (Screen) -> Unit) {
    LazyColumnFor(items = doctors, modifier = Modifier.fillMaxWidth().padding(16.dp)) { item ->
        DoctorCard(item, onItemClicked)
    }
}

@Composable
fun DoctorCard(doctor: DoctorModel, onItemClicked: (Screen) -> Unit = {}) {
    Card(
        modifier = Modifier.fillMaxWidth().clickable(onClick = {
            onItemClicked.invoke(Screen.DoctorInfo(doctor))
        }),
        shape = RoundedCornerShape(20.dp),
        backgroundColor = Color(0xffFFEEE0),
        elevation = 0.dp
    ) {
        Row(
            modifier = Modifier.padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalGravity = ContentGravity.CenterVertically
        ) {
            Image(
                asset = imageResource(id = doctor.profile),
                modifier = Modifier.preferredSize(56.dp)
            )
            Column(
                modifier = Modifier.padding(start = 0.dp, end = 16.dp, top = 8.dp, bottom = 8.dp),
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
            val context = ContextAmbient.current
            Button(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                onClick = {
                    context.startActivity(
                        Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", doctor.telephone, null))
                    )
                },
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