package ru.nsu.medvedev.v

class DSL {
    fun student(block: StudentBuilder.() -> Unit) : Student = StudentBuilder().apply(block).build()

    fun taskList(block: TaskBuilder.() -> Unit) : TaskList = TaskBuilder().apply(block).build()

    val student = student {
        name = "Valdemar Medvedev"
        nickName = "vald"
        repoUrl = "steamcommunity.com/id/vovademar/"
        tasks {
            givenTask {
                taskId = "task 2.4.1"
                deadLine = "20-12-2022"
            }
            givenTask {
                taskId = "task 2.3.1"
                deadLine = "12-12-2022"
            }
        }
        group {
            name = 20214
        }
        lessons {
            lesson {
                attendance = true
                date = "12-12-2022"
            }
        }
        lectures{
            lecture {
                attendance = true
                date = "10-10-2022"
            }
        }
        marks{
            mark {
                grade = 5
                date = "12-12-2022"
            }
        }
    }
    val tasks = taskList {
        tasks {
            task {
                taskId = "Task 2.4.1"
                taskName = "DSL"
                score = 2
            }
            task {
                taskId = "Task 2.3.1"
                taskName = "SNAKE"
                score = 1
            }
        }
    }

}

fun main() {
    val dsl = DSL()
    println(dsl.student)
    println(dsl.tasks)
}