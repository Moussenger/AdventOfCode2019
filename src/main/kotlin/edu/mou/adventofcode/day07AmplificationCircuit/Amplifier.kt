package edu.mou.adventofcode.day07AmplificationCircuit

import edu.mou.adventofcode.tools.intcode.IntCodeInterpreter

data class Amplifier(val code: String, val phaseSetting: Int) {
    private val interpreter = IntCodeInterpreter(code, mutableListOf(phaseSetting), pauseOnEmptyInput = true)

    fun run(signal: Int = 0): Int {
        interpreter.input(listOf(signal))
        interpreter.run()
        return interpreter.output().last()
    }

    fun isHalted(): Boolean {
        return interpreter.isHalted()
    }
}