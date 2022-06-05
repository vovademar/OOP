package ru.nsu.medvedev.v

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class LessonsBuilder {
    private val dateTimeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")

    private var lessonDate: LocalDate = LocalDate.parse("05-06-1337", dateTimeFormatter)
    var date: String = ""
        set(value) {
            lessonDate = LocalDate.parse(value, dateTimeFormatter)
        }

    var attendance = false
    fun build(): Lesson {
        if (lessonDate == LocalDate.parse("05-06-1337", dateTimeFormatter)) {
            throw IllegalArgumentException("Date of the lesson is empty")
        }
        return Lesson(lessonDate, attendance)
    }

}
