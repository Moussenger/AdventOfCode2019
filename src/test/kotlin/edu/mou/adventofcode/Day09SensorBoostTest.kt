package edu.mou.adventofcode

import edu.mou.adventofcode.day09SensorBoost.Day09SensorBoost
import edu.mou.adventofcode.tools.DayProblemTest

class Day09SensorBoostTest :
    DayProblemTest<Day09SensorBoost, Long, Long>(
        dayProblem = Day09SensorBoost::class,
        expectedPart1 = 3780860499,
        argsPart1 = listOf("1"),
        expectedPart2 = 3780860499,
        argsPart2 = listOf("1"),
    )