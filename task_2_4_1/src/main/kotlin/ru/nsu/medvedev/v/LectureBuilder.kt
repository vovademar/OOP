package ru.nsu.medvedev.v

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class LectureBuilder {
    private val dateTimeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")

    private var lectureDate: LocalDate = LocalDate.parse("05-06-1337", dateTimeFormatter)
    var date: String = ""
        set(value) {
            lectureDate = LocalDate.parse(value, dateTimeFormatter)
        }

    var attendance = false
    fun build(): Lecture {
        if (lectureDate == LocalDate.parse("05-06-1337", dateTimeFormatter)) {
            throw IllegalArgumentException("Date of the lecture is empty")
        }
        return Lecture(lectureDate, attendance)
    }

}