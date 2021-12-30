package edu.mou.adventofcode

import edu.mou.adventofcode.day03CrossedWires.Day03CrossedWires
import edu.mou.adventofcode.tools.DayProblemTest

class Day03CrossedWiresTest :
    DayProblemTest<Day03CrossedWires, Int, Int>(
        dayProblem = Day03CrossedWires::class,
        expectedPart1 = 6,
        expectedPart2 = 30
    )