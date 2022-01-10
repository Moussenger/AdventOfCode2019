package edu.mou.adventofcode

import edu.mou.adventofcode.day13CarePackage.Day13CarePackage
import edu.mou.adventofcode.tools.DayProblemTest

class Day13CarePackageTest :
    DayProblemTest<Day13CarePackage, Int, Int>(
        dayProblem = Day13CarePackage::class,
        expectedPart1 = 255,
        expectedPart2 = 12338
    )