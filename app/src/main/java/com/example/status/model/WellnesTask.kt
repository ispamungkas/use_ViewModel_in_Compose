package com.example.status.model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

class WellnesTask(
    val id: Int,
    val textName: String,
    initialChecked : Boolean = false
){
    var checked: MutableState<Boolean> = mutableStateOf(initialChecked)
}