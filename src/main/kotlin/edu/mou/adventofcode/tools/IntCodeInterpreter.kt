package edu.mou.adventofcode.tools

class IntCodeInterpreter(val code: MutableList<Int>) {
    companion object {
        private const val ADD = 1
        private const val PRODUCT = 2
        private const val HALT = 99

        private const val NEXT = 4
    }

    tailrec fun run(pointer: Int = 0): Int {
        when (code[pointer]) {
            ADD -> add(code[pointer + 1], code[pointer + 2], code[pointer + 3])
            PRODUCT -> product(code[pointer + 1], code[pointer + 2], code[pointer + 3])
            HALT -> return code[0]
        }

        return run(pointer + NEXT)
    }

    private fun add(firstPosition: Int, secondPosition: Int, resultPosition: Int) {
        code[resultPosition] = code[firstPosition] + code[secondPosition]
    }

    private fun product(firstPosition: Int, secondPosition: Int, resultPosition: Int) {
        code[resultPosition] = code[firstPosition] * code[secondPosition]
    }
}