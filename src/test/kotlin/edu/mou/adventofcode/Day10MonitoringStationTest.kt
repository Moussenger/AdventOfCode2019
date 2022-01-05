package edu.mou.adventofcode

import edu.mou.adventofcode.day10MonitoringStation.Day10MonitoringStation
import edu.mou.adventofcode.tools.DayProblemTest

class Day10MonitoringStationTest :
    DayProblemTest<Day10MonitoringStation, Int, Int>(
        dayProblem = Day10MonitoringStation::class,
        expectedPart1 = 210,
        expectedPart2 = 802,
    )