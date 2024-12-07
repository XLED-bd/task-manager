package com.codewizards.taskmanager.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.codewizards.taskmanager.model.Task
import com.codewizards.taskmanager.viewmodel.TaskViewModel

@Composable
fun AboutTask(id: Int, taskViewModel: TaskViewModel) {
    val task = taskViewModel.tasks[id]
    Spacer(modifier = Modifier.height(8.dp))
    AboutTaskDescr(task, onComleteChange = { taskViewModel.completeTask(id) })
}

@Composable
fun AboutTaskDescr(task:Task, onComleteChange: (Boolean)->Unit){
    var text_to_change by remember { mutableStateOf("") }

    Column(Modifier.fillMaxSize())
    {
        Text(text = task.name,
            modifier = Modifier.padding(vertical = 10.dp).padding(start = 5.dp),
            fontSize = 20.sp)

        Text(text = task.description,
            modifier = Modifier.padding(vertical = 10.dp).padding(start = 5.dp),
            fontSize = 20.sp)

        Text(text =  if (task.isComplete) "Выполнено" else "Не выполнено",
            modifier = Modifier.padding(vertical = 10.dp).padding(start = 5.dp),
            fontSize = 20.sp)

        Button(
            modifier = Modifier.padding(vertical = 10.dp).padding(end=5.dp).align(Alignment.End),
            onClick = {
                onComleteChange(task.isComplete)
            })
        {
            Text(text = if (task.isComplete) "Выполнено" else "Не выполнено")
        }
        Button(modifier = Modifier.padding(vertical = 10.dp).padding(end=5.dp).align(Alignment.End),
            onClick = {


            })
        {
            Text(text = "Изменить описание")

        }
        TextField(
            value = text_to_change,
            onValueChange = { text_to_change = it },
            placeholder = { Text(text = "Изменить") },
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp)
        )
    }
}



@Preview(showBackground = true)
@Composable
fun GreetPreview() {
    val taskViewModel = TaskViewModel()

    taskViewModel.addTask("1414", "1234124")

     AboutTask(0, taskViewModel = taskViewModel)
}