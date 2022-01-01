package edu.mou.adventofcode

import edu.mou.adventofcode.day05SunnyChanceAsteroids.Day05SunnyChanceAsteroids
import edu.mou.adventofcode.tools.DayProblemTest

class Day05SunnyChanceAsteroidsTest :
    DayProblemTest<Day05SunnyChanceAsteroids, Int, Int>(
        dayProblem = Day05SunnyChanceAsteroids::class,
        argsPart1 = listOf("33"),
        expectedPart1 = 33,
        argsPart2 = listOf("1", "8"),
        expectedPart2 = 1
    )