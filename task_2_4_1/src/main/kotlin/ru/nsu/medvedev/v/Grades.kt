package ru.nsu.medvedev.v

class Grades : ArrayList<Grade>() {
    fun mark(block: GradeBuilder.() -> Unit){
        add(GradeBuilder().apply(block).build())
    }

}
