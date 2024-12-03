package com.codewizards.taskmanager.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codewizards.taskmanager.model.Task
import com.codewizards.taskmanager.viewmodel.TaskViewModel


@Composable
fun TaskManager(taskViewModel: TaskViewModel,  modifier: Modifier){

    Column (modifier = modifier.fillMaxSize()) {
        TextFieldTask(onAddTask = { title, descrip -> taskViewModel.addTask(title, descrip) })
        Spacer(modifier = Modifier.height(8.dp))
        TaskList(taskViewModel)
    }
}

@Composable
fun TaskList(taskViewModel: TaskViewModel) {
    val tasks = taskViewModel.tasks

    LazyColumn {
        items(tasks){ task ->
            TaskItem(task)
        }
    }
}

@Composable
fun TaskItem(task: Task) {
    Card (
        Modifier.fillMaxWidth(). padding(horizontal = 20.dp, vertical = 7.dp))
    {
        Box (Modifier.fillMaxWidth()) {
            Text(text = task.name,
                modifier = Modifier.padding(vertical = 10.dp).padding(start = 5.dp),
                fontSize = 20.sp)
            Button(modifier = Modifier.align(Alignment.CenterEnd), onClick = {}){

            }
        }
    }
}

@Composable
fun TextFieldTask(onAddTask: (String, String) -> Unit){
    var text_title by remember { mutableStateOf("") }
    var text_descp by remember { mutableStateOf("") }

    Column {
        TextField(
            value = text_title,
            onValueChange = { text_title = it },
            placeholder = { Text(text = "Введите тему") },
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp)
        )
        TextField(
            value = text_descp,
            onValueChange = { text_descp = it },
            placeholder = { Text(text = "Введите описание") },
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp)
        )
        Button(
            onClick = {
                onAddTask(text_title, text_descp)
                text_title = ""
                text_descp = ""
            },
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp))
        {
            Text(text = "Добавить")
        }
    }
}