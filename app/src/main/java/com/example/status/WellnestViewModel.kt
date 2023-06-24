package com.example.status

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.example.status.model.WellnesTask

class WellnestViewModel: ViewModel() {
    private val _list = getWellnesTasks().toMutableStateList()
    val getList : List<WellnesTask>
        get() = _list

    fun remove(item : WellnesTask) {
        _list.remove(item)
    }

    fun changeTaskChecked(item: WellnesTask, currentCheck: Boolean) = getList.find { it.id == item.id }?.let {task ->
        task.checked.value = currentCheck
    }
}

private fun getWellnesTasks() = List(30) { i -> WellnesTask(i, "item ke $i") }