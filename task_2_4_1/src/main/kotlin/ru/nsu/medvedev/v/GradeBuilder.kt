package ru.nsu.medvedev.v

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class GradeBuilder {
    var grade = 0
    private val dateTimeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")

    private var markDate: LocalDate = LocalDate.parse("05-06-1337", dateTimeFormatter)
    var date: String = ""
        set(value) {
            markDate = LocalDate.parse(value, dateTimeFormatter)
        }


    fun build(): Grade {
        if (grade == 0) {
            throw IllegalArgumentException("Mark is empty")
        }
        if (markDate == LocalDate.parse("05-06-1337", dateTimeFormatter)){
            throw IllegalArgumentException("Deadline is empty")
        }
        return Grade(grade, markDate)
    }
}
