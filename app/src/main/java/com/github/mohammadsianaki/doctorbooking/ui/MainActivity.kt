package com.github.mohammadsianaki.doctorbooking.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.Crossfade
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.lifecycle.ViewModelProvider
import com.github.mohammadsianaki.doctorbooking.ui.theme.AppTheme
import com.github.mohammadsianaki.doctorbooking.util.NavigationViewModel
import com.github.mohammadsianaki.doctorbooking.util.Screen

class MainActivity : AppCompatActivity() {
    private lateinit var navigationViewModel: NavigationViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigationViewModel = ViewModelProvider(this)[NavigationViewModel::class.java]
        setContent {
            DoctorBookingApp(navigationViewModel)
        }
    }

    override fun onBackPressed() {
        if (!navigationViewModel.onBackPressed()) {
            super.onBackPressed()
        }
    }

    @Composable
    fun DoctorBookingApp(navigationViewModel: NavigationViewModel) {
        AppTheme {
            AppContent(navigationViewModel)
        }
    }

    @Composable
    fun AppContent(navigationViewModel: NavigationViewModel) {
        Crossfade(current = navigationViewModel.currentScreen) { screen ->
            when (screen) {
                is Screen.Home -> HomeScreen(navigationViewModel::navigateTo)
                is Screen.DoctorInfo -> DoctorInfoScreen(navigationViewModel::onBackPressed)
            }
        }
    }
}