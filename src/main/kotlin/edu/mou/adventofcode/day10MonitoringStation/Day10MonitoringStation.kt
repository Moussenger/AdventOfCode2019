package edu.mou.adventofcode.day10MonitoringStation

import edu.mou.adventofcode.tools.DayProblem
import edu.mou.adventofcode.tools.models.Point
import edu.mou.adventofcode.tools.models.toPoints
import edu.mou.adventofcode.tools.zip

class Day10MonitoringStation :
    DayProblem<Int, Int>(day = "10", name = "Monitoring Station") {

    override fun solvePart1(vararg args: String): Int {
        return bestAsteroid().second
    }

    override fun solvePart2(vararg args: String): Int {
        val asteroids = asteroids()
        val bestAsteroid = bestAsteroid().first

        val asteroidsByLaser = asteroids
            .filter { it != bestAsteroid }
            .groupBy { bestAsteroid.angleTo(it) }
            .map { it.key to it.value.sortedBy { point -> bestAsteroid.squareDistanceTo(point) } }
            .sortedByDescending { it.first }
            .map { it.second }
            .zip()
            .flatten()

        return asteroidsByLaser[199].x * 100 + asteroidsByLaser[199].y
    }

    private fun asteroids(): List<Point> {
        return input.toPoints("#")
    }

    private fun bestAsteroid(): Pair<Point, Int> {
        val points = asteroids()
        val visibles = points.map { it to points.map { other -> other.angleTo(it) }.distinct().count() }
        return visibles.maxByOrNull { it.second }!!
    }

}

fun main() {
    println("Part 1: ${Day10MonitoringStation().solvePart1()}")
    println("Part 2: ${Day10MonitoringStation().solvePart2()}")
}