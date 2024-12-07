package com.codewizards.taskmanager.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.codewizards.taskmanager.model.Task

class TaskViewModel: ViewModel() {
    private val _tasks = mutableStateListOf<Task>()
    val tasks: List<Task> = _tasks

    fun addTask(title:String, descript:String){
        _tasks.add(Task(_tasks.size, title,descript,false))
    }

    fun completeTask(id: Int){
        _tasks[id] = _tasks[id].copy(isComplete = !_tasks[id].isComplete)
    }

    fun changeTaskDescrip(id: Int, description: String){
        _tasks[id] = _tasks[id].copy(description = description)
    }

}