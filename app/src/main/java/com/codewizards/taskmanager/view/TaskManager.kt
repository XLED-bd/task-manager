package com.codewizards.taskmanager.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.codewizards.taskmanager.viewmodel.TaskViewModel


@Composable
fun TaskManager(taskViewModel: TaskViewModel){


    Column {
        TextFieldTask()
    }
}


@Composable
fun TextFieldTask(){
    var text_title by remember { mutableStateOf("") }
    var text_descp by remember { mutableStateOf("") }


    Column{
        TextField(
            value = text_title,
            onValueChange = { text_title = it }
        )
        TextField(
            value = text_descp,
            onValueChange = { text_descp = it }
        )
        Button(onClick = {   }) { }
    }

}