package com.codewizards.taskmanager.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.codewizards.taskmanager.viewmodel.TaskViewModel

@Composable
fun AboutTask(int: Int, taskViewModel: TaskViewModel) {
    val task = taskViewModel.tasks[int]

    Text(task.name)
}