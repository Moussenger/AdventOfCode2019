package edu.mou.adventofcode

import edu.mou.adventofcode.day02The1202ProgramAlarm.Day02The1202ProgramAlarm
import edu.mou.adventofcode.tools.DayProblemTest

class Day02The1202ProgramAlarmTest :
    DayProblemTest<Day02The1202ProgramAlarm, Int, Int>(
        dayProblem = Day02The1202ProgramAlarm::class,
        expectedPart1 = 3500,
        expectedPart2 = 910,
        argsPart2 = listOf("3500")
    )