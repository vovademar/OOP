package ru.nsu.medvedev.v

class StudentBuilder {
    var name = ""
    var nickName = ""
    var repoUrl = ""

    lateinit var group: Group
    fun group(block: GroupBuilder.() -> Unit) {
        group = GroupBuilder().apply(block).build()
    }

    var givenTasks = mutableListOf<AssignedTask>()

    fun tasks(block: AssignedTasks.() -> Unit){
        givenTasks.addAll(AssignedTasks().apply(block))
    }

    private var lessons = mutableListOf<Lesson>()
    fun lessons(block: Lessons.() -> Unit){
        lessons.addAll(Lessons().apply(block))
    }

    private var lectures = mutableListOf<Lecture>()
    fun lectures(block: Lectures.() -> Unit){
        lectures.addAll(Lectures().apply(block))
    }

    var marks = mutableListOf<Grade>()
    fun marks(block: Grades.() -> Unit){
        marks.addAll(Grades().apply(block))
    }

    fun build(): Student {
        if (nickName == ""){
            throw IllegalArgumentException("Nickname is empty")
        }
        else if (name == "") {
            throw IllegalArgumentException("Name is empty")
        }
        else if (repoUrl == ""){
            throw IllegalArgumentException("URL of repository is empty")
        }
        return Student(nickName, name, repoUrl, group, givenTasks, lessons, lectures, marks)
    }
}