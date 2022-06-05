package ru.nsu.medvedev.v

class AssignedTasks : ArrayList<AssignedTask>(){
    fun givenTask(block: AssignedTaskBuilder.() -> Unit){
        add(AssignedTaskBuilder().apply(block).build())
    }

}
