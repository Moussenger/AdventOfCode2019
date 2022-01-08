package edu.mou.adventofcode

import edu.mou.adventofcode.day12TheNBodyProblem.Day12TheNBodyProblem
import edu.mou.adventofcode.tools.DayProblemTest

class Day12TheNBodyProblemTest :
    DayProblemTest<Day12TheNBodyProblem, Int, Long>(
        dayProblem = Day12TheNBodyProblem::class,
        expectedPart1 = 179,
        argsPart1 = listOf("10"),
        expectedPart2 = 2772
    )