package edu.mou.adventofcode.day02The1202ProgramAlarm

import edu.mou.adventofcode.tools.DayProblem
import edu.mou.adventofcode.tools.intcode.IntCodeInterpreter

class Day02The1202ProgramAlarm : DayProblem<Long, Long>(day = "02", name = "1202 Program Alarm") {
    override fun solvePart1(vararg args: String): Long {
        return parseInput().run { IntCodeInterpreter(code = this.toMutableList()).run() }
    }

    override fun solvePart2(vararg args: String): Long {
        val numberToReach = args.first().toLong()
        val initialCode = parseInput()
        var solution = 0L

        search@ for (noun in 0..99L) {
            for (verb in 0..99L) {
                val code = initialCode.toMutableList()
                code[1] = noun
                code[2] = verb

                try {
                    if (IntCodeInterpreter(code, limitMemoryToProgram = true).run() == numberToReach) {
                        solution = 100 * noun + verb
                        break@search
                    }
                } catch (_: Exception) {
                }
            }
        }

        return solution
    }

    private fun parseInput(): List<Long> {
        return input.flatMap { it.split(",") }.map { it.toLong() }
    }
}

fun main() {
    println("Part 1: ${Day02The1202ProgramAlarm().solvePart1()}")
    println("Part 2: ${Day02The1202ProgramAlarm().solvePart2("19690720")}")
}