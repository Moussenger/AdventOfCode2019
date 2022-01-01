package edu.mou.adventofcode

import edu.mou.adventofcode.day06UniversalOrbitMap.Day06UniversalOrbitMap
import edu.mou.adventofcode.tools.DayProblemTest

class Day06UniversalOrbitMapTest :
    DayProblemTest<Day06UniversalOrbitMap, Int, Int>(
        dayProblem = Day06UniversalOrbitMap::class,
        expectedPart1 = 54,
        expectedPart2 = 4,
    )