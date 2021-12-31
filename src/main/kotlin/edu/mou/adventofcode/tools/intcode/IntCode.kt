package edu.mou.adventofcode.tools.intcode

class IntCode(private val code: MutableList<Int>) {
    private val pointer: IntCodePointer = IntCodePointer()

    fun position(delta: Int = 0): Int {
        return code[positionValue(delta)]
    }

    fun put(delta: Int = 0, value: Int) {
        code[positionValue(delta)] = value
    }

    fun move(delta: Int) {
        pointer.move(delta)
    }

    fun moveTo(position: Int) {
        pointer.moveTo(position)
    }

    fun look(delta: Int = 0): Int {
        return code[pointer.lookAfter(delta)]
    }

    private fun positionValue(delta: Int = 0): Int {
        return look(delta)
    }
}