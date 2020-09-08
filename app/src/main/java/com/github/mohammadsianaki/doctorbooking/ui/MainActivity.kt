package com.github.mohammadsianaki.doctorbooking.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.ui.tooling.preview.Preview
import com.github.mohammadsianaki.doctorbooking.ui.theme.AppTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DoctorBookingApp()
        }
    }

    @Composable
    @Preview
    fun DoctorBookingApp() {
        AppTheme {
            DashboardContent()
        }
    }

}