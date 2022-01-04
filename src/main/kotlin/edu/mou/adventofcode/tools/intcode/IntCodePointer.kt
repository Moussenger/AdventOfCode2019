package edu.mou.adventofcode.tools.intcode

class IntCodePointer {
    private var pointer: Long = 0

    fun move(delta: Long) {
        pointer += delta
    }

    fun moveTo(position: Long) {
        pointer = position
    }

    fun look(): Long {
        return pointer
    }

    fun lookAfter(delta: Long): Long {
        return pointer + delta
    }
}