package edu.mou.adventofcode.tools.intcode

class IntCodeInterpreter(code: MutableList<Int>, input: MutableList<Int> = mutableListOf()) {
    private val intCode: IntCode

    constructor(code: String, input: MutableList<Int> = mutableListOf()) :
            this(code.split(",").map { it.toInt() }.toMutableList(), input)

    init {
        intCode = IntCode(code, input)
    }

    fun output(): List<Int> {
        return intCode.output()
    }

    tailrec fun run(): Int {
        val (operator, modes) = IntCodeOperator.parse(intCode.look())

        val currentPointer = intCode.where()
        operator.exec(intCode, *modes.toIntArray())

        if (operator.isHalt) {
            return intCode.look()
        }

        if (intCode.where() == currentPointer) intCode.move(operator.opSize + 1)

        return run()
    }
}