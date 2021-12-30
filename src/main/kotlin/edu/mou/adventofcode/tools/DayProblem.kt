package edu.mou.adventofcode.tools

import java.io.File

abstract class DayProblem<P1, P2>(val day: String, val name: String) {
    val input: List<String> = File(javaClass.getResource("/day$day/input.txt")!!.path).readLines()

    abstract fun solvePart1(vararg args: String): P1
    abstract fun solvePart2(vararg args: String): P2
}
