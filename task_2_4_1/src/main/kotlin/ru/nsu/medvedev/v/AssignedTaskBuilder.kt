package ru.nsu.medvedev.v

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class AssignedTaskBuilder {
    private val dateTimeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")

    var taskId = ""
    private var deadLineDate: LocalDate = LocalDate.parse("05-06-1337", dateTimeFormatter)
    var deadLine: String = ""
    set(value) {
        deadLineDate = LocalDate.parse(value, dateTimeFormatter)
    }
    fun build(): AssignedTask {
        if (taskId == ""){
            throw IllegalArgumentException("TaskID is empty")
        }
        if (deadLineDate == LocalDate.parse("05-06-1337", dateTimeFormatter)){
            throw IllegalArgumentException("Deadline is empty")
        }
        return AssignedTask(taskId, deadLineDate)
    }

}
