package ru.nsu.medvedev.v

class TaskBuilder {

    var tasks = mutableListOf<Task>()
    fun tasks(block: Tasks.() -> Unit){
        tasks.addAll(Tasks().apply(block))
    }

    var taskId = ""
    var taskName = ""
    var score = -1
    fun buildTask(): Task {
        if (taskId == ""){
            throw IllegalArgumentException("TaskID is empty")
        }
        if (taskName == ""){
            throw IllegalArgumentException("Task name is empty")
        }
        if (score == -1) {
            throw IllegalArgumentException("Score is empty")
        }
        return Task(taskId, taskName, score)
    }

    fun build(): TaskList {
        return TaskList(tasks)
    }

}
