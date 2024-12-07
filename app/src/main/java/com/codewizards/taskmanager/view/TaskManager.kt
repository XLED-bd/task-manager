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
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.codewizards.taskmanager.model.Task
import com.codewizards.taskmanager.viewmodel.TaskViewModel


@Composable
fun TaskManager(taskViewModel: TaskViewModel,  modifier: Modifier){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "main"){

        composable("main") {
            Column (modifier = modifier.fillMaxSize()) {
                TextFieldTask(onAddTask = { title, descrip -> taskViewModel.addTask(title, descrip) })
                Spacer(modifier = Modifier.height(8.dp))
                TaskList(taskViewModel, onClickDetail = {
                    taskId ->
                    navController.navigate("task_detail/$taskId")
                })
            }
        }
        composable("task_detail/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType})
            ){ task ->
                AboutTask(task.arguments!!.getInt("id"), taskViewModel)
        }
    }
}

@Composable
fun TaskList(taskViewModel: TaskViewModel, onClickDetail: (Int) -> Unit ) {
    val tasks = taskViewModel.tasks

    LazyColumn {
        items(tasks){ task ->
            TaskItem(task, onDetail = {taskId -> onClickDetail(taskId)})
        }
    }
}

@Composable
fun TaskItem(task: Task, onDetail: (Int) -> Unit) {
    Card (
        Modifier.fillMaxWidth(). padding(horizontal = 20.dp, vertical = 7.dp))
    {
        Box (Modifier.fillMaxWidth()) {
            Text(text = task.name,
                modifier = Modifier.padding(vertical = 10.dp).padding(start = 5.dp),
                fontSize = 20.sp)
            Column (modifier = Modifier.align(Alignment.CenterEnd)) {
                Button(
                modifier = Modifier.padding(vertical = 10.dp).padding(end=5.dp),
                onClick = { onDetail(task.id) })
                {
                    Text(text = "Подробности")
                }
                Button(
                    modifier = Modifier.padding(vertical = 10.dp).padding(end=5.dp).align(Alignment.End),
                    onClick = { })
                {
                    Text(text = "Удалить")
                }
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
                if (text_title.isNotEmpty()){
                    onAddTask(text_title, text_descp)
                    text_title = ""
                    text_descp = ""
                }
            },
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp))
        {
            Text(text = "Добавить")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

    val taskViewModel = TaskViewModel()

    taskViewModel.addTask("234234", "141243")

    TaskManager(taskViewModel, Modifier.padding(0.dp))

}