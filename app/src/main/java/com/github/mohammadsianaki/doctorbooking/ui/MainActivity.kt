package com.github.mohammadsianaki.doctorbooking.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.Crossfade
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.lifecycle.ViewModelProvider
import com.github.mohammadsianaki.doctorbooking.ui.dashboard.HomeScreen
import com.github.mohammadsianaki.doctorbooking.ui.detail.DoctorInfoScreen
import com.github.mohammadsianaki.doctorbooking.ui.theme.AppTheme
import com.github.mohammadsianaki.doctorbooking.util.NavigationViewModel
import com.github.mohammadsianaki.doctorbooking.util.Screen

class MainActivity : AppCompatActivity() {
    private lateinit var navigationViewModel: NavigationViewModel
    private lateinit var dashboardViewModel: DashboardViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigationViewModel = ViewModelProvider(this)[NavigationViewModel::class.java]
        dashboardViewModel = ViewModelProvider(this)[DashboardViewModel::class.java]
        setContent {
            DoctorBookingApp(navigationViewModel, dashboardViewModel)
        }
    }

    override fun onBackPressed() {
        if (!navigationViewModel.onBackPressed()) {
            super.onBackPressed()
        }
    }

    @Composable
    fun DoctorBookingApp(
        navigationViewModel: NavigationViewModel,
        dashboardViewModel: DashboardViewModel
    ) {
        AppTheme {
            AppContent(navigationViewModel)
        }
    }

    @Composable
    fun AppContent(navigationViewModel: NavigationViewModel) {
        Crossfade(current = navigationViewModel.currentScreen) { screen ->
            when (screen) {
                is Screen.Home -> HomeScreen(navigationViewModel::navigateTo, dashboardViewModel)
                is Screen.DoctorInfo -> DoctorInfoScreen(
                    navigationViewModel::onBackPressed,
                    screen.doctorModel
                )
            }
        }
    }
}