package edu.mou.adventofcode.tools.intcode

class IntCodeInterpreter(
    code: MutableList<Long>,
    input: MutableList<Long> = mutableListOf(),
    private val pauseOnEmptyInput: Boolean = false,
    limitMemoryToProgram: Boolean = false,
) {
    private val intCode: IntCode
    private var halted: Boolean = false

    constructor(
        code: String,
        input: MutableList<Long> = mutableListOf(),
        pauseOnEmptyInput: Boolean = false,
        limitMemoryToProgram: Boolean = false,
    ) :
            this(code.split(",").map { it.toLong() }.toMutableList(), input, pauseOnEmptyInput, limitMemoryToProgram)

    init {
        intCode = IntCode(
            code.mapIndexed { index, value -> index.toLong() to value }.toMap().toMutableMap(),
            input,
            limitMemoryToProgram,
        )
    }

    fun output(): List<Long> {
        return intCode.output()
    }

    fun input(values: List<Long>) {
        intCode.input(values)
    }

    tailrec fun run(): Long {
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

        if (intCode.where() == currentPointer) intCode.move(operator.opSize + 1L)

        return run()
    }

    fun isHalted(): Boolean {
        return halted
    }
}