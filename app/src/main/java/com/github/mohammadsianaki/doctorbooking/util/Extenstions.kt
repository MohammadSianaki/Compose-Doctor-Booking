package com.github.mohammadsianaki.doctorbooking.util

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

fun <T> MutableStateFlow<T>.asStateFlow(): StateFlow<T> = this