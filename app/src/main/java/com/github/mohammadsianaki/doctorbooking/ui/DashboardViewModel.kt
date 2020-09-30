package com.github.mohammadsianaki.doctorbooking.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.mohammadsianaki.doctorbooking.data.DataFactory
import com.github.mohammadsianaki.doctorbooking.model.DoctorModel
import com.github.mohammadsianaki.doctorbooking.model.SpecialityModel
import com.github.mohammadsianaki.doctorbooking.util.asStateFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

class DashboardViewModel : ViewModel() {
    private val _viewState = MutableStateFlow(DashboardViewState())
    val viwState = _viewState.asStateFlow()

    private val selectedCategory = MutableStateFlow(0)
    private val categories = DataFactory.getCategories()
    private val doctors = DataFactory.getDoctors()

    init {
        viewModelScope.launch {
            combine(
                categories,
                selectedCategory,
                doctors
            ) { categories, selectedCategory, doctors ->
                DashboardViewState(
                    doctors = doctors,
                    categories = categories,
                    selectedCategory = selectedCategory
                )
            }.collect {
                _viewState.value = it
            }
        }
    }

    fun onCategorySelected(index: Int) {
        selectedCategory.value = index
    }
}


data class DashboardViewState(
    val doctors: List<DoctorModel> = emptyList(),
    val categories: List<Category> = emptyList(),
    val selectedCategory: Int = 0
)

data class Category(
    val name: String = "",
    val specialists: List<SpecialityModel> = emptyList()
)