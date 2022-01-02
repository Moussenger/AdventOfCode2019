package edu.mou.adventofcode.tools.intcode

class IntCode(private val code: MutableList<Int>, private val input: MutableList<Int> = mutableListOf()) {
    private val pointer: IntCodePointer = IntCodePointer()
    private val output: MutableList<Int> = mutableListOf()
    private var mode: (Int) -> Int = this::position

    fun setMode(flag: Int) {
        if (flag == 0) setPositionMode() else setImmediateMode()
    }

    fun where(): Int {
        return pointer.look()
    }

    fun value(delta: Int): Int {
        return mode.invoke(delta)
    }

    fun input(): Int {
        return input.removeFirst()
    }

    fun input(values: List<Int>) {
        input.addAll(values)
    }

    fun output(): List<Int> {
        return output.toList()
    }

    fun output(delta: Int) {
        output.add(mode.invoke(delta))
    }

    fun position(delta: Int = 0): Int {
        return code[positionValue(delta)]
    }

    fun immediate(delta: Int = 0): Int {
        return look(delta)
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

    private fun setPositionMode() {
        this.mode = this::position
    }

    private fun setImmediateMode() {
        this.mode = this::immediate
    }

    private fun positionValue(delta: Int = 0): Int {
        return look(delta)
    }
}