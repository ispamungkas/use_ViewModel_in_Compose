package com.example.status.model

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import com.example.status.WellnesTaskItem


@Composable
fun WellnesTaskList(
    modifier: Modifier = Modifier,
    list: List<WellnesTask>,
    onCloseTask: (WellnesTask) -> Unit,
    onCheckTask: (WellnesTask, Boolean) -> Unit
) {
    LazyColumn(
        modifier = Modifier,
        state = rememberLazyListState()
    ) {
        items(
            items = list,
            key = { item -> item.id }
        ) { item ->
            WellnesTaskItem(
                textName = item.textName,
                checked = item.checked.value,
                onClose = {
                    onCloseTask(item)
                },
                onCheckedChange = { newvalue ->
                    onCheckTask(item , newvalue)
                }
            )
        }
    }
}