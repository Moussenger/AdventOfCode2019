package edu.mou.adventofcode.day08SpaceImageFormat

import edu.mou.adventofcode.tools.DayProblem
import edu.mou.adventofcode.tools.zip

class Day08SpaceImageFormat(inputFile: String = "input.txt") :
    DayProblem<Int, String>(day = "08", name = "Space Image Format", inputFile = inputFile) {

    override fun solvePart1(vararg args: String): Int {
        val (width, height) = sizing(*args)

        return getLayers(width, height)
            .map { Pair(it, it.filter { pixel -> pixel == '0' }.length) }
            .minByOrNull { it.second }!!
            .run { first.filter { it == '1' }.length * first.filter { it == '2' }.length }
    }

    override fun solvePart2(vararg args: String): String {
        val (width, height) = sizing(*args)

        return getLayers(width, height)
            .map { it.toList() }
            .zip()
            .map { it.firstOrNull { pixel -> pixel != '2' } }
            .map { if (it == '1') "#" else " " }
            .chunked(width)
            .toMutableList()
            .apply { add(0, listOf("")) }
            .joinToString("\n") { it.joinToString("") }
    }

    private fun getLayers(width: Int, height: Int): List<String> {
        return input.first().chunked(width * height)
    }

    private fun sizing(vararg args: String): Pair<Int, Int> {
        return Pair(args[0].toInt(), args[1].toInt())
    }

}

fun main() {
    println("Part 1: ${Day08SpaceImageFormat().solvePart1("25", "6")}")
    println("Part 2: \n${Day08SpaceImageFormat().solvePart2("25", "6")}")
}