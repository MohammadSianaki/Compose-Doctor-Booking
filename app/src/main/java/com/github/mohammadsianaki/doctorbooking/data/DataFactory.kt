package com.github.mohammadsianaki.doctorbooking.data

import androidx.compose.ui.graphics.Color
import com.github.mohammadsianaki.doctorbooking.ui.DoctorModel
import com.github.mohammadsianaki.doctorbooking.ui.Speciality
import com.github.mohammadsianaki.doctorbooking.util.Drawables

object DataFactory {

    fun getSpeciality() = mutableListOf<Speciality>().apply {
        add(
            Speciality(
                numberOfDoctors = 10,
                speciality = "Cough and Cold",
                backgroundColor = Color(0xffFBB97C),
                image = Drawables.img1
            )
        )
        add(
            Speciality(
                numberOfDoctors = 17,
                speciality = "Heart Specialist",
                backgroundColor = Color(0xffF69383),
                image = Drawables.img2
            )
        )

        add(
            Speciality(
                numberOfDoctors = 27,
                speciality = "Diabetes Care",
                backgroundColor = Color(0xffEACBCB),
                image = Drawables.img3
            )
        )
    }

    fun getDoctors() = mutableListOf<DoctorModel>().apply {
        add(
            DoctorModel(
                name = "Dr. Stefani Albert",
                speciality = "Heart Specialist",
                profile = Drawables.doctor_pic,
                telephone = "+98 4000"
            )
        )
    }
}