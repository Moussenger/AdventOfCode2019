package edu.mou.adventofcode.day07AmplificationCircuit

import edu.mou.adventofcode.tools.AocMath
import edu.mou.adventofcode.tools.DayProblem
import kotlin.math.max

class Day07AmplificationCircuit(inputFile: String = "input.txt") :
    DayProblem<Long, Long>(day = "07", name = "Amplification Circuit", inputFile = inputFile) {

    override fun solvePart1(vararg args: String): Long {
        return runAmplifiers(args[0].toInt()..args[1].toInt())
    }

    override fun solvePart2(vararg args: String): Long {
        return runAmplifiers(args[0].toInt()..args[1].toInt())
    }

    private fun runAmplifiers(phaseSettings: IntRange): Long {
        val program = input.first()
        var higherSignal = Long.MIN_VALUE

        for (inputValues in AocMath.permutations(phaseSettings)) {
            val signal = AmplifierCircuit(inputValues.map { Amplifier(program, it.toLong()) }).run()

            higherSignal = max(higherSignal, signal)
        }

        return higherSignal
    }
}

fun main() {
    println("Part 1: ${Day07AmplificationCircuit().solvePart1("0", "4")}")
    println("Part 2: ${Day07AmplificationCircuit().solvePart2("5", "9")}")
}