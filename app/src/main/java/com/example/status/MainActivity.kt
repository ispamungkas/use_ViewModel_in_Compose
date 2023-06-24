package com.example.status

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.status.model.WellnesTask
import com.example.status.model.WellnesTaskList
import com.example.status.ui.theme.StatusTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StatusTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Screen()
                }
            }
        }
    }
}


@Composable
fun Screen(
    modifier: Modifier = Modifier,
    wellnestViewModel: WellnestViewModel = viewModel(),
) {
    Column(
        modifier = Modifier
    ) {
        StatefullCounter()

        WellnesTaskList(
            list = wellnestViewModel.getList,
            onCloseTask = { item ->
                wellnestViewModel.remove(
                    item
                )
            },
            onCheckTask = { task, checked ->
                wellnestViewModel.changeTaskChecked(task, checked)
            }
        )
    }
}

@Composable
fun StatelessCounter(
    count: Int,
    onIncrement: () -> Unit,
    modifier: Modifier = Modifier
) {

    val interaction = remember {
        MutableInteractionSource()
    }
    val isPress by interaction.collectIsPressedAsState()
    val color = if (isPress) Color.Red else Color.Blue

    if (count > 0) {
        Text("you have ${count} glass")
    }

    Row(
        modifier = Modifier,
        horizontalArrangement = Arrangement.End
    ) {
        Button(
            onClick = onIncrement,
            enabled = count < 10,
            interactionSource = interaction,
            colors = ButtonDefaults.buttonColors(
                containerColor = color
            ),
            shape = RoundedCornerShape(0),
            modifier = Modifier
                .padding(horizontal = 6.dp)
        ) {
            Text("Add one")
        }
    }
}

@Composable
fun StatefullCounter(
    modifier: Modifier = Modifier
) {
    var count by rememberSaveable { mutableStateOf(0) }
    StatelessCounter(count = count, onIncrement = { count++ }, modifier)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StatusTheme {
        StatefullCounter()
    }
}