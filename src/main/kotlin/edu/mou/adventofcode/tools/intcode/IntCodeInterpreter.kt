package edu.mou.adventofcode.tools.intcode

class IntCodeInterpreter(
    code: MutableList<Int>,
    input: MutableList<Int> = mutableListOf(),
    private val pauseOnEmptyInput: Boolean = false,
) {
    private val intCode: IntCode
    private var halted: Boolean = false

    constructor(code: String, input: MutableList<Int> = mutableListOf(), pauseOnEmptyInput: Boolean = false) :
            this(code.split(",").map { it.toInt() }.toMutableList(), input, pauseOnEmptyInput)

    init {
        intCode = IntCode(code, input)
    }

    fun output(): List<Int> {
        return intCode.output()
    }

    fun input(values: List<Int>) {
        intCode.input(values)
    }

    tailrec fun run(): Int {
        val (operator, modes) = IntCodeOperator.parse(intCode.look())

        val currentPointer = intCode.where()

        try {
            operator.exec(intCode, *modes.toIntArray())
        } catch (error: Exception) {
            if (operator.isInput() && pauseOnEmptyInput) {
                return output().lastOrNull() ?: 0
            }

            throw error
        }


        if (operator.isHalt) {
            halted = true
            return intCode.look()
        }

        if (intCode.where() == currentPointer) intCode.move(operator.opSize + 1)

        return run()
    }

    fun isHalted(): Boolean {
        return halted
    }
}