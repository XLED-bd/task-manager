package com.codewizards.taskmanager.model

data class Task(
    val name: String,
    val description: String,
    val isComplete: Boolean
)