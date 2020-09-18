package com.github.mohammadsianaki.doctorbooking.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class SpecialityModel(
    @DrawableRes val image: Int,
    val speciality: String,
    val numberOfDoctors: Int,
    val backgroundColor: Color,
)