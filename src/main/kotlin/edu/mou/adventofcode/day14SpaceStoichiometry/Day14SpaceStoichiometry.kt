package edu.mou.adventofcode.day14SpaceStoichiometry

import edu.mou.adventofcode.tools.DayProblem

class Day14SpaceStoichiometry : DayProblem<Long, Long>(day = "14", name = "Space Stoichiometry") {
    override fun solvePart1(vararg args: String): Long {
        return Stoichiometry(parseReactives()).getOREForFuel()
    }

    override fun solvePart2(vararg args: String): Long {
        val oreAvailable = 1_000_000_000_000L
        var increment = 10_000_000L
        var multiplier = 0L
        var found = false
        val stoichiometry = Stoichiometry(parseReactives())

        while (!found) {
            multiplier += increment
            val ore = stoichiometry.getOREForFuel(multiplier = multiplier)

            when {
                ore == oreAvailable -> found = true
                ore > oreAvailable && increment == 1L -> {
                    found = true; multiplier--
                }
                ore > oreAvailable -> {
                    multiplier -= increment; increment /= 10
                }
            }
        }

        return multiplier
    }

    private fun parseReactives(): Map<Reactive, List<Reactive>> {
        return input
            .map { it.split(" => ").reversed() }
            .map { it[0] to it[1] }
            .map { it.first.split(" ") to it.second.split(", ").map { element -> element.split(" ") } }
            .associate {
                Reactive(it.first[1]).apply {
                    quantity = it.first[0].toInt()
                } to it.second.map { reactive -> Reactive(reactive[1]).apply { quantity = reactive[0].toInt() } }
            }
    }
}

fun main() {
    println("Part 1: ${Day14SpaceStoichiometry().solvePart1()}")
    println("Part 2: ${Day14SpaceStoichiometry().solvePart2()}")
}