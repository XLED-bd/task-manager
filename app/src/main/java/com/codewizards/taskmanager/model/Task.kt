package com.codewizards.taskmanager.model

data class Task(
    val id: Int,
    val name: String,
    val description: String,
    var isComplete: Boolean
)