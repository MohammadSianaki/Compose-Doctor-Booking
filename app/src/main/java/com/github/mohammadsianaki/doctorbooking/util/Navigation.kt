package com.github.mohammadsianaki.doctorbooking.util

import androidx.annotation.MainThread
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.github.mohammadsianaki.doctorbooking.model.DoctorModel


sealed class Screen {
    object Home : Screen()
    data class DoctorInfo(val doctorModel: DoctorModel) : Screen()
}

class NavigationViewModel : ViewModel() {
    var currentScreen by mutableStateOf<Screen>(Screen.Home)
        private set

    @MainThread
    fun onBackPressed(): Boolean {
        return if (currentScreen != Screen.Home) {
            currentScreen = Screen.Home
            true
        } else {
            false
        }
    }

    @MainThread
    fun navigateTo(screen: Screen) {
        currentScreen = screen
    }
}