package edu.mou.adventofcode.day09SensorBoost

import edu.mou.adventofcode.tools.DayProblem
import edu.mou.adventofcode.tools.intcode.IntCodeInterpreter

class Day09SensorBoost(inputFile: String = "input.txt") :
    DayProblem<Long, Long>(day = "09", name = "Sensor Boost", inputFile = inputFile) {

    override fun solvePart1(vararg args: String): Long {
        return runBOOST(args.first().toLong())
    }

    override fun solvePart2(vararg args: String): Long {
        return runBOOST(args.first().toLong())
    }

    private fun runBOOST(instruction: Long): Long {
        return IntCodeInterpreter(input.first(), mutableListOf(instruction)).apply { run() }.output().first()
    }

}

fun main() {
    println("Part 1: ${Day09SensorBoost().solvePart1("1")}")
    println("Part 2: ${Day09SensorBoost().solvePart2("2")}")
}