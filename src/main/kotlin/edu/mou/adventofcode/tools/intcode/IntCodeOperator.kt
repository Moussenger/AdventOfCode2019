package edu.mou.adventofcode.tools.intcode

sealed class IntCodeOperator(val opSize: Int, val isHalt: Boolean = false) {
    companion object {
        private val operatorsMap = mapOf(
            1 to Add,
            2 to Product,
            3 to Input,
            4 to Output,
            5 to JumpIfTrue,
            6 to JumpIfFalse,
            7 to LessThan,
            8 to Equals,
            99 to Halt
        )

        fun parse(operator: Int): Pair<IntCodeOperator, List<Int>> {
            val operatorParts = operator.toString().padStart(5, '0').toList()
            val opCode = operatorParts.takeLast(2).joinToString("").toInt()
            val modes = operatorParts.take(3).reversed().map { it.toString().toInt() }

            return Pair(operatorsMap.getValue(opCode), modes)
        }
    }

    abstract fun exec(intCode: IntCode, vararg modes: Int)
}

private object Add : IntCodeOperator(3) {
    override fun exec(intCode: IntCode, vararg modes: Int) {
        intCode.setMode(modes[0])
        val first = intCode.value(1)

        intCode.setMode(modes[1])
        val second = intCode.value(2)

        intCode.put(3, first + second)
    }
}

private object Product : IntCodeOperator(3) {
    override fun exec(intCode: IntCode, vararg modes: Int) {
        intCode.setMode(modes[0])
        val first = intCode.value(1)

        intCode.setMode(modes[1])
        val second = intCode.value(2)

        intCode.put(3, first * second)
    }
}

private object Input : IntCodeOperator(1) {
    override fun exec(intCode: IntCode, vararg modes: Int) {
        intCode.setMode(modes[0])
        intCode.put(1, intCode.input())
    }
}

private object Output : IntCodeOperator(1) {
    override fun exec(intCode: IntCode, vararg modes: Int) {
        intCode.setMode(modes[0])
        intCode.output(1)
    }
}

private object JumpIfTrue : IntCodeOperator(2) {
    override fun exec(intCode: IntCode, vararg modes: Int) {
        intCode.setMode(modes[0])
        val jump = intCode.value(1) != 0

        intCode.setMode(modes[1])
        if (jump) intCode.moveTo(intCode.value(2))
    }
}

private object JumpIfFalse : IntCodeOperator(2) {
    override fun exec(intCode: IntCode, vararg modes: Int) {
        intCode.setMode(modes[0])
        val jump = intCode.value(1) == 0

        intCode.setMode(modes[1])
        if (jump) intCode.moveTo(intCode.value(2))
    }
}

private object LessThan : IntCodeOperator(3) {
    override fun exec(intCode: IntCode, vararg modes: Int) {
        intCode.setMode(modes[0])
        val first = intCode.value(1)

        intCode.setMode(modes[1])
        val second = intCode.value(2)

        if (first < second) intCode.put(3, 1) else intCode.put(3, 0)
    }
}

private object Equals : IntCodeOperator(3) {
    override fun exec(intCode: IntCode, vararg modes: Int) {
        intCode.setMode(modes[0])
        val first = intCode.value(1)

        intCode.setMode(modes[1])
        val second = intCode.value(2)

        if (first == second) intCode.put(3, 1) else intCode.put(3, 0)
    }
}

private object Halt : IntCodeOperator(0, isHalt = true) {
    override fun exec(intCode: IntCode, vararg modes: Int) {
        intCode.moveTo(0)
    }
}