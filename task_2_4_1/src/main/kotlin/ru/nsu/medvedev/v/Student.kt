package ru.nsu.medvedev.v

data class Student(
    var nickName: String,
    var name: String,
    var studentLink: String,
    var group: Group,
    var tasks: List<AssignedTask>,
    val lessons: List<Lesson>,
    val lectures: MutableList<Lecture>,
    val marks: List<Grade>
)
