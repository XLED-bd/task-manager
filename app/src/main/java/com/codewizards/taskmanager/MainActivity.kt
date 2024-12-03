package com.codewizards.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import com.codewizards.taskmanager.ui.theme.TaskmanagerTheme
import com.codewizards.taskmanager.view.TaskManager
import com.codewizards.taskmanager.viewmodel.TaskViewModel

class MainActivity : ComponentActivity() {

    val taskViewModel: TaskViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        enableEdgeToEdge()
        setContent {
            TaskmanagerTheme {
                TaskManager(taskViewModel)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TaskmanagerTheme {
    }
}