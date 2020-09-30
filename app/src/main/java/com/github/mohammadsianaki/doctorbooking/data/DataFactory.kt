package com.github.mohammadsianaki.doctorbooking.data

import androidx.compose.ui.graphics.Color
import com.github.mohammadsianaki.doctorbooking.model.DoctorModel
import com.github.mohammadsianaki.doctorbooking.model.SpecialityModel
import com.github.mohammadsianaki.doctorbooking.ui.Category
import com.github.mohammadsianaki.doctorbooking.util.Drawables
import kotlinx.coroutines.flow.MutableStateFlow

object DataFactory {

    private fun getSpeciality() = mutableListOf<SpecialityModel>().apply {
        add(
            SpecialityModel(
                numberOfDoctors = 10,
                speciality = "Cough and Cold",
                backgroundColor = Color(0xffFBB97C),
                image = Drawables.img1
            )
        )
        add(
            SpecialityModel(
                numberOfDoctors = 17,
                speciality = "Heart Specialist",
                backgroundColor = Color(0xffF69383),
                image = Drawables.img2
            )
        )

        add(
            SpecialityModel(
                numberOfDoctors = 27,
                speciality = "Diabetes Care",
                backgroundColor = Color(0xffEACBCB),
                image = Drawables.img3
            )
        )
    }

    fun getCategories(): MutableStateFlow<List<Category>> {
        return MutableStateFlow(mutableListOf<Category>().apply {
            add(
                Category("Adults", getSpeciality())
            )
            add(Category("Childrens"))
            add(Category("Womens"))
            add(Category("Mens"))
        })
    }

    fun getDoctors(): MutableStateFlow<MutableList<DoctorModel>> {
        return MutableStateFlow(mutableListOf<DoctorModel>().apply {
            add(
                DoctorModel(
                    name = "Dr. Stefani Albert",
                    speciality = "Heart Specialist",
                    profile = Drawables.doctor_pic,
                    secondaryProfile = Drawables.doctor_pic2,
                    telephone = "+98 4000",
                    address = "House # 2, Road # 5, Green Road Dhanmondi, Dhaka, Bangladesh",
                    daily = "Monday - Friday Open till 7 Pm",
                    about = "Dr. Stefeni Albert is a cardiologist in Nashville & affiliated with multiple hospitals in the  area.He received his medical degree from Duke University School of Medicine and has been in practice for more than 20 years. "
                )
            )
        })
    }
}