package edu.mou.adventofcode.tools.intcode

class IntCode(
    private val memory: MutableMap<Long, Long>,
    private val input: MutableList<Long> = mutableListOf(),
    private val limitMemoryToProgram: Boolean = false
) {
    private val pointer: IntCodePointer = IntCodePointer()
    private val output: MutableList<Long> = mutableListOf()
    private var mode: (Long) -> Long = this::position
    private var relativeBase: Long = 0
    private val programSize: Long = memory.values.size.toLong()

    fun setRelativeBase(base: Long) {
        this.relativeBase += base
    }

    fun setMode(flag: Int) {
        when (flag) {
            1 -> setImmediateMode()
            2 -> setRelativeMode()
            else -> setPositionMode()
        }

    }

    fun where(): Long {
        return pointer.look()
    }

    fun value(delta: Long): Long {
        return mode.invoke(delta)
    }

    fun input(): Long {
        return input.removeFirst()
    }

    fun input(values: List<Long>) {
        input.addAll(values)
    }

    fun output(): List<Long> {
        return output.toList()
    }

    fun output(delta: Long) {
        output.add(mode.invoke(delta))
    }

    fun put(delta: Long = 0, value: Long) {
        val realDelta = if (mode == this::relative) relativeBase + look(delta) else look(delta)

        checkMemoryLimitAtAbsolute(realDelta)
        memory[realDelta] = value
    }

    fun move(delta: Long) {
        checkMemoryLimit(delta)
        pointer.move(delta)
    }

    fun moveTo(position: Long) {
        pointer.moveTo(position)
        checkMemoryLimit()
    }

    fun look(delta: Long = 0): Long {
        checkMemoryLimit(delta)
        return memory.getOrDefault(pointer.lookAfter(delta), 0)
    }

    private fun position(delta: Long = 0): Long {
        checkMemoryLimitAtAbsolute(look(delta))
        return memory.getOrDefault(look(delta), 0)
    }

    private fun immediate(delta: Long = 0): Long {
        return look(delta)
    }

    private fun relative(delta: Long = 0): Long {
        checkMemoryLimitAtAbsolute(relativeBase + look(delta))
        return memory.getOrDefault(relativeBase + look(delta), 0)
    }

    private fun setPositionMode() {
        this.mode = this::position
    }

    private fun setRelativeMode() {
        this.mode = this::relative
    }

    private fun setImmediateMode() {
        this.mode = this::immediate
    }

    private fun checkMemoryLimit(delta: Long = 0) {
        if (limitMemoryToProgram && pointer.lookAfter(delta) >= programSize) {
            throw Exception("IntCode: Memory read out of limits")
        }
    }

    private fun checkMemoryLimitAtAbsolute(position: Long = 0) {
        if (limitMemoryToProgram && position >= programSize) {
            throw Exception("IntCode: Memory read out of limits")
        }
    }
}