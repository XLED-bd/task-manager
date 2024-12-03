package com.codewizards.taskmanager.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codewizards.taskmanager.model.Task
import com.codewizards.taskmanager.viewmodel.TaskViewModel

@Composable
fun AboutTask(int: Int, taskViewModel: TaskViewModel) {
    val task = taskViewModel.tasks[int]

    Text(task.name)
}

@Composable
fun AboutTaskDescr( task:Task, onComleteChange: (Boolean)->Unit){
    Column {
        Text(text = task.name,
            modifier = Modifier.padding(vertical = 10.dp).padding(start = 5.dp),
            fontSize = 20.sp)

        Text(text = task.description,
            modifier = Modifier.padding(vertical = 10.dp).padding(start = 5.dp),
            fontSize = 20.sp)

        Button(
            modifier = Modifier.padding(vertical = 10.dp).padding(end=5.dp).align(Alignment.End),
            onClick = {
                onComleteChange(task.isComplete)
                isComplete = true

            })
        {
            Text(text = "Выполнено")
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetPreview() {

    val aboutTask = AboutTask(0, taskViewModel = TaskViewModel())


}