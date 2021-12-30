package edu.mou.adventofcode

import edu.mou.adventofcode.day02_1202ProgramAlarm.Day021202ProgramAlarm
import edu.mou.adventofcode.tools.DayProblemTest

class Day01TyrannyRocketEquationTest :
    DayProblemTest<Day021202ProgramAlarm, Int, Int>(
        dayProblem = Day021202ProgramAlarm::class,
        expectedPart1 = 34241,
        expectedPart2 = 51316
    )