package com.github.mohammadsianaki.doctorbooking.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.github.mohammadsianaki.doctorbooking.data.DataFactory
import com.github.mohammadsianaki.doctorbooking.model.DoctorModel
import com.github.mohammadsianaki.doctorbooking.ui.components.EmphasizedText
import com.github.mohammadsianaki.doctorbooking.util.Drawables


@Composable
fun DoctorInfo(doctorModel: DoctorModel = DataFactory.getDoctors()[0]) {
    Scaffold(
        topBar = { AppBar() },
    ) {
        ScrollableColumn {
            Row(
                Modifier
                    .wrapContentHeight()
                    .padding(horizontal = 32.dp, vertical = 16.dp)
            ) {
                Image(
                    modifier = Modifier.preferredHeight(220.dp),
                    asset = imageResource(id = Drawables.doctor_pic2),
                    contentScale = ContentScale.Fit,
                )
                Box {
                    EmphasizedText(
                        text = doctorModel.name, textStyle = TextStyle(
                            color = Color(0xDD000000).copy(alpha = 0.8f),
                            fontSize = 32.sp
                        ),
                        modifier = Modifier.padding(start = 16.dp, top = 16.dp)
                    )
                    Text(
                        text = doctorModel.speciality,
                        fontSize = 16.sp,
                        color = Color.Gray,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                    Row(
                        Modifier.padding(top = 32.dp).fillMaxWidth().gravity(Alignment.Bottom),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        IconButton(
                            onClick = {},
                            modifier = Modifier.background(
                                color = Color(0xffFFECDD),
                                shape = RoundedCornerShape(10.dp)
                            )
                        ) {
                            Icon(asset = imageResource(id = Drawables.email))
                        }
                        IconButton(
                            onClick = {},
                            modifier = Modifier.background(
                                color = Color(0xffFEF2F0),
                                shape = RoundedCornerShape(10.dp)
                            )
                        ) {
                            Icon(asset = imageResource(id = Drawables.call))
                        }
                        IconButton(
                            onClick = {},
                            modifier = Modifier.background(
                                color = Color(0xffEBECEF),
                                shape = RoundedCornerShape(10.dp)
                            )
                        ) {
                            Icon(asset = imageResource(id = Drawables.video_call))
                        }
                    }
                }
            }
        }
    }
}


@Composable
@Preview
fun DoctorInfoPreview() {
    MaterialTheme {
        DoctorInfo()
    }
}