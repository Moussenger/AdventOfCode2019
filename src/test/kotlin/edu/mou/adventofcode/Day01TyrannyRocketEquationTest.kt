package edu.mou.adventofcode

import edu.mou.adventofcode.day01TyrannyRocketEquation.Day01TyrannyRocketEquation
import edu.mou.adventofcode.tools.DayProblemTest

class Day01TyrannyRocketEquationTest :
    DayProblemTest<Day01TyrannyRocketEquation, Int, Int>(
        dayProblem = Day01TyrannyRocketEquation::class,
        expectedPart1 = 34241,
        expectedPart2 = 51316
    )