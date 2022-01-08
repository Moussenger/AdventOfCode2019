package edu.mou.adventofcode.day12TheNBodyProblem

import edu.mou.adventofcode.tools.AocMath
import edu.mou.adventofcode.tools.combinations
import edu.mou.adventofcode.tools.models.Point

class MoonSystem(private val moons: List<Moon>) {
    fun cycleLength(): Long {
        val xCycle = cycleLengthFor({ it.position.x }, { it.velocity.x }).toLong()
        val yCycle = cycleLengthFor({ it.position.y }, { it.velocity.y }).toLong()
        val zCycle = cycleLengthFor({ it.position.z }, { it.velocity.z }).toLong()

        return AocMath.lcm(xCycle, yCycle, zCycle)
    }

    fun energy(): Int {
        return moons.sumOf { it.energy() }
    }

    fun applyGravity(universe: List<Moon> = moons) {
        universe.combinations(2).forEach { (moon1, moon2) ->
            val (delta1, delta2) = calculateDeltas(moon1.position, moon2.position)
            moon1.updateVelocity(delta1)
            moon2.updateVelocity(delta2)
        }

        universe.forEach { it.applyVelocity() }
    }

    private fun calculateDeltas(position1: Point, position2: Point): Pair<Point, Point> {
        val (x1, y1, z1) = position1
        val (x2, y2, z2) = position2

        val (deltaX1, deltaX2) = calculateDelta(x1, x2)
        val (deltaY1, deltaY2) = calculateDelta(y1, y2)
        val (deltaZ1, deltaZ2) = calculateDelta(z1, z2)

        return Pair(Point(deltaX1, deltaY1, deltaZ1), Point(deltaX2, deltaY2, deltaZ2))
    }

    private fun calculateDelta(value1: Int, value2: Int): Pair<Int, Int> {
        return when {
            value1 > value2 -> Pair(-1, 1)
            value1 < value2 -> Pair(1, -1)
            else -> Pair(0, 0)
        }
    }

    private fun cycleLengthFor(mapping: (Moon) -> Int, velMapping: (Moon) -> Int): Int {
        val originals = moons.map(mapping)
        val universe = copyMoons()
        var cycleCount = 0

        do {
            applyGravity(universe)
            cycleCount++
        } while (universe.map(mapping) != originals || universe.map(velMapping).any { it != 0 })

        return cycleCount
    }

    private fun copyMoons(): List<Moon> {
        return moons.map { it.copy(position = it.position.copy(), velocity = it.velocity.copy()) }
    }
}