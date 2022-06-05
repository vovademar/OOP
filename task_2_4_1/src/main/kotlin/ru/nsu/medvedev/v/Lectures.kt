package ru.nsu.medvedev.v

class Lectures : ArrayList<Lecture>(){
    fun lecture(block: LectureBuilder.() -> Unit){
        add(LectureBuilder().apply(block).build())
    }
}
