package edu.mou.adventofcode.tools.intcode

class IntCodeInterpreter(code: MutableList<Int>) {
    private val intCode: IntCode

    init {
        intCode = IntCode(code)
    }

    tailrec fun run(): Int {
        val operator = IntCodeOperator.parse(intCode.look())

        operator.exec(intCode)

        if (operator.isHalt) {
            return intCode.look()
        }

        intCode.move(operator.opSize + 1)

        return run()
    }
}