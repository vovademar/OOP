package ru.nsu.medvedev.v

import ru.nsu.medvedev.v.Group

class GroupBuilder {
    var name = 0

    fun build(): Group {
        if (name == 0){
            throw IllegalArgumentException("Number of group is empty")
        }
        return Group(name)
    }

}
