package ru.nsu.medvedev.v

class Lessons : ArrayList<Lesson>(){
    fun lesson(block: LessonsBuilder.() -> Unit){
        add(LessonsBuilder().apply(block).build())
    }
}
