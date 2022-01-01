package edu.mou.adventofcode.day06UniversalOrbitMap

import edu.mou.adventofcode.tools.DayProblem

class Day06UniversalOrbitMap : DayProblem<Int, Int>(day = "06", name = "Universal Orbit Map") {
    override fun solvePart1(vararg args: String): Int {
        return orbitsCount(parseOrbits(), "COM")
    }

    override fun solvePart2(vararg args: String): Int {
        val orbits = parseOrbits()

        val youPath = looksFor(orbits, "YOU").toMutableList().apply { remove("YOU") }.toSet()
        val santaPath = looksFor(orbits, "SAN").toMutableList().apply { remove("SAN") }.toSet()

        val youOwnPath = youPath - santaPath
        val santaOwnPath = santaPath - youPath

        return youOwnPath.size + santaOwnPath.size
    }

    private fun parseOrbits(): Map<String, List<String>> {
        return input.map { it.split(")") }.groupBy({ it[0] }, { it[1] })
    }

    private fun orbitsCount(orbits: Map<String, List<String>>, me: String, count: Int = 0): Int {
        val spaceObjects = orbits[me] ?: return count

        var newCount = 0
        val nextCount = 1 + count

        for (spaceObject in spaceObjects) {
            newCount += orbitsCount(orbits, spaceObject, nextCount)
        }

        return count + newCount
    }

    private fun looksFor(orbits: Map<String, List<String>>, spaceObject: String, from: String = "COM"): List<String> {
        val orbiters = orbits[from] ?: return listOf()

        for (orbiter in orbiters) {
            if (orbiter == spaceObject) return listOf(spaceObject)

            val path = looksFor(orbits, spaceObject, orbiter)

            if (path.isNotEmpty()) return listOf(orbiter) + path
        }

        return listOf()
    }

}

fun main() {
    println("Part 1: ${Day06UniversalOrbitMap().solvePart1()}")
    println("Part 2: ${Day06UniversalOrbitMap().solvePart2()}")
}