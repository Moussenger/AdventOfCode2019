package edu.mou.adventofcode.tools.intcode

class IntCodePointer {
    private var pointer: Int = 0

    fun move(delta: Int) {
        pointer += delta
    }

    fun moveTo(position: Int) {
        pointer = position
    }

    fun look(): Int {
        return pointer
    }

    fun lookAfter(delta: Int): Int {
        return pointer + delta
    }
}