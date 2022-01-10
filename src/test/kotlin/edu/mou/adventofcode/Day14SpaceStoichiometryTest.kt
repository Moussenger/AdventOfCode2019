package edu.mou.adventofcode

import edu.mou.adventofcode.day14SpaceStoichiometry.Day14SpaceStoichiometry
import edu.mou.adventofcode.tools.DayProblemTest

class Day14SpaceStoichiometryTest :
    DayProblemTest<Day14SpaceStoichiometry, Long, Long>(
        dayProblem = Day14SpaceStoichiometry::class,
        expectedPart1 = 13312,
        expectedPart2 = 82892753
    )