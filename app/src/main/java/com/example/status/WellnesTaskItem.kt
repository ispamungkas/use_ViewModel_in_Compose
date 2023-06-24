package com.example.status

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun WellnesTaskItem(
    taskName: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onClose: () -> Unit,
    modifier: Modifier = Modifier,
){
    Row(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = taskName,
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp)
        )
        Checkbox(checked = checked, onCheckedChange =  onCheckedChange)
        IconButton(
            onClick = onClose
        ) {
            Icon(imageVector = Icons.Filled.Close, contentDescription = "iconClose")
        }
    }
}

@Composable
fun WellnesTaskItem(
    textName : String,
    checked: Boolean,
    modifier: Modifier = Modifier,
    onClose: () -> Unit,
    onCheckedChange: (Boolean) -> Unit
){
    WellnesTaskItem(
        taskName = textName,
        checked = checked,
        onCheckedChange = { newValue ->
            onCheckedChange(newValue)
        },
        onClose = onClose
    )
}