package edu.mou.adventofcode.day02_1202ProgramAlarm

import edu.mou.adventofcode.tools.DayProblem

class Day021202ProgramAlarm : DayProblem<Int, Int>(day = "02", name = "1202 Program Alarm") {
    override fun solvePart1(vararg args: String): Int {
        return parseInput().run { IntCodeInterpreter(code = this.toMutableList()).run() }
    }

    override fun solvePart2(vararg args: String): Int {
        val numberToReach = args.first().toInt()
        val initialCode = parseInput()
        var solution = 0

        search@ for (noun in 0..99) {
            for (verb in 0..99) {
                val code = initialCode.toMutableList()
                code[1] = noun
                code[2] = verb

                try {
                    if (IntCodeInterpreter(code).run() == numberToReach) {
                        solution = 100 * noun + verb
                        break@search
                    }
                } catch (_: IndexOutOfBoundsException) {
                }
            }
        }

        return solution
    }

    private fun parseInput(): List<Int> {
        return input.flatMap { it.split(",") }.map { it.toInt() }
    }
}

fun main() {
    println("Part 1: ${Day021202ProgramAlarm().solvePart1()}")
    println("Part 2: ${Day021202ProgramAlarm().solvePart2("19690720")}")
}