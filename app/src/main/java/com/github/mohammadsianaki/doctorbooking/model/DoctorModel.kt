package com.github.mohammadsianaki.doctorbooking.model

import androidx.annotation.DrawableRes

data class DoctorModel(
    val name: String = "",
    val speciality: String = "",
    @DrawableRes val profile: Int,
    @DrawableRes val secondaryProfile: Int,
    val telephone: String = "",
    val address:String = "",
    val daily:String ="",
    val about: String = ""
)
