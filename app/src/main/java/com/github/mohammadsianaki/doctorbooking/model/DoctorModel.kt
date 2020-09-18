package com.github.mohammadsianaki.doctorbooking.model

import androidx.annotation.DrawableRes

data class DoctorModel(
    val name: String,
    val speciality: String,
    @DrawableRes val profile: Int,
    val telephone: String
)
