package com.codewizards.taskmanager.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.CreationExtras
import com.codewizards.taskmanager.model.Task

class TaskViewModel: ViewModel() {
    private val _tasks = mutableStateListOf<Task>()
    val task: List<Task> = _tasks




}