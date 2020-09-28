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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.github.mohammadsianaki.doctorbooking.data.DataFactory
import com.github.mohammadsianaki.doctorbooking.model.DoctorModel
import com.github.mohammadsianaki.doctorbooking.ui.components.EmphasizedText
import com.github.mohammadsianaki.doctorbooking.util.Drawables


@Composable
fun DoctorInfoScreen(onBack: () -> Unit, doctorModel: DoctorModel = DataFactory.getDoctors()[0]) {
    Scaffold(
        topBar = { AppBar(true, onBack) },
    ) {
        ScrollableColumn {
            ProfileSection(doctorModel)
            AboutSection()
            ActivitySection()
        }
    }
}

@Composable
fun ProfileSection(doctorModel: DoctorModel) {
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
                color = Color(0xFF9E9E9E),
                modifier = Modifier.padding(start = 16.dp)
            )
            Row(
                Modifier.padding(top = 32.dp).fillMaxWidth().gravity(Alignment.Bottom),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                IconButton(
                    onClick = {},
                    enabled = false,
                    modifier = Modifier.background(
                        color = Color(0xffFFECDD),
                        shape = RoundedCornerShape(10.dp)
                    )
                ) {
                    Icon(asset = imageResource(id = Drawables.email))
                }
                IconButton(
                    onClick = {},
                    enabled = false,
                    modifier = Modifier.background(
                        color = Color(0xffFEF2F0),
                        shape = RoundedCornerShape(10.dp)
                    )
                ) {
                    Icon(asset = imageResource(id = Drawables.call))
                }
                IconButton(
                    onClick = {},
                    enabled = false,
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

@Composable
fun AboutSection() {
    Text(
        text = "About",
        style = TextStyle(fontSize = 22.sp),
        modifier = Modifier.padding(start = 32.dp, top = 16.dp)
    )
    Text(
        text = "Dr. Stefeni Albert is a cardiologist in Nashville & affiliated with multiple hospitals in the  area.He received his medical degree from Duke University School of Medicine and has been in practice for more than 20 years. ",
        style = TextStyle(color = Color(0xFF9E9E9E), fontSize = 16.sp),
        modifier = Modifier.padding(horizontal = 32.dp, vertical = 16.dp),
    )
    Row(Modifier.padding(horizontal = 32.dp, vertical = 16.dp)) {
        Column(Modifier.fillMaxHeight().weight(1f)) {
            Row {
                Image(
                    asset = imageResource(id = Drawables.mappin),
                    Modifier.gravity(Alignment.CenterVertically)
                )
                Column(Modifier.padding(start = 16.dp)) {
                    Text(
                        text = "Address", style = TextStyle(
                            color = Color.Black.copy(alpha = 0.7f),
                            fontSize = 20.sp
                        )
                    )
                    Text(
                        text = "House # 2, Road # 5, Green Road Dhanmondi, Dhaka, Bangladesh",
                        style = TextStyle(color = Color.Gray)
                    )
                }
            }
            Row(modifier = Modifier.padding(top = 16.dp)) {
                Image(
                    asset = imageResource(id = Drawables.clock),
                    Modifier.gravity(Alignment.CenterVertically)
                )
                Column(Modifier.padding(start = 16.dp)) {
                    Text(
                        text = "Daily Practice", style = TextStyle(
                            color = Color.Black.copy(alpha = 0.7f),
                            fontSize = 20.sp
                        )
                    )
                    Text(
                        text = "Monday - Friday Open till 7 Pm",
                        style = TextStyle(color = Color.Gray)
                    )
                }
            }
        }
        Image(
            asset = imageResource(id = Drawables.map),
            modifier = Modifier.fillMaxHeight().weight(1f)
        )
    }
}

@Composable
fun ActivitySection() {
    Text(
        text = "Activity", style = TextStyle(
            color = Color(0xff242424),
            fontSize = 28.sp,
            fontWeight = FontWeight.SemiBold
        ),
        modifier = Modifier.padding(horizontal = 32.dp)
    )
    Row(horizontalArrangement = Arrangement.SpaceEvenly) {
        ActivityCard(
            text = "List of Schedule",
            backgroundColor = Color(0xffFCCA9B),
            imageBackgroundColor = Color(0xffFBB97C),
            modifier = Modifier.padding(start = 16.dp, end = 8.dp, top = 24.dp, bottom = 24.dp)
                .preferredHeight(100.dp)
        )

        ActivityCard(
            text = "Doctor's Daily Post",
            backgroundColor = Color(0xffA5A5A5),
            imageBackgroundColor = Color(0xffBBBBBB),
            modifier = Modifier.padding(start = 8.dp, end = 16.dp, top = 24.dp, bottom = 24.dp)
                .preferredHeight(100.dp)
        )
    }
}

@Composable
fun ActivityCard(
    text: String,
    backgroundColor: Color,
    imageBackgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Box(
        backgroundColor = backgroundColor,
        shape = RoundedCornerShape(20.dp),
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxHeight(),
            horizontalArrangement = Arrangement.Center,
            verticalGravity = ContentGravity.CenterVertically
        ) {
            Image(
                asset = imageResource(id = Drawables.list), modifier = Modifier
                    .padding(end = 8.dp, start = 16.dp, top = 16.dp, bottom = 16.dp).background(
                        color = imageBackgroundColor,
                        shape = RoundedCornerShape(16.dp)
                    ).padding(8.dp)
            )
            Text(
                text = text, style = TextStyle(
                    color = Color.White,
                    fontSize = 17.sp
                ),
                modifier = Modifier.padding(end = 16.dp, start = 8.dp, top = 16.dp, bottom = 16.dp)
            )
        }
    }
}

@Composable
@Preview
fun DoctorInfoPreview() {
    MaterialTheme {
        DoctorInfoScreen(onBack = {})
    }
}