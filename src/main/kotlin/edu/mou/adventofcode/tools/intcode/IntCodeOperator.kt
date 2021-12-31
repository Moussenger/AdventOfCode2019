package edu.mou.adventofcode.tools.intcode

sealed class IntCodeOperator(val opSize: Int, val isHalt: Boolean = false) {
    companion object {
        private val operatorsMap = mapOf(
            1 to Add,
            2 to Product,
            99 to Halt
        )

        fun parse(operator: Int): IntCodeOperator {
            return operatorsMap.getValue(operator)
        }
    }

    abstract fun exec(intCode: IntCode)
}

private object Add : IntCodeOperator(3) {
    override fun exec(intCode: IntCode) {
        intCode.put(3, intCode.position(1) + intCode.position(2))
    }
}

private object Product : IntCodeOperator(3) {
    override fun exec(intCode: IntCode) {
        intCode.put(3, intCode.position(1) * intCode.position(2))
    }
}

private object Halt : IntCodeOperator(0, isHalt = true) {
    override fun exec(intCode: IntCode) {
        intCode.moveTo(0)
    }
}