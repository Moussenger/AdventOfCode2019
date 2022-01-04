import edu.mou.adventofcode.tools.DayProblem
import org.reflections.Reflections
import org.reflections.scanners.Scanners
import org.reflections.util.ClasspathHelper
import org.reflections.util.ConfigurationBuilder
import org.reflections.util.FilterBuilder
import kotlin.reflect.full.createInstance

val dayArguments = mapOf<Int, Pair<List<String>?, List<String>?>>(
    2 to Pair(null, listOf("19690720")),
    5 to Pair(listOf("1"), listOf("5")),
    7 to Pair(listOf("0", "4"), listOf("5", "9")),
    8 to Pair(listOf("25", "6"), listOf("25", "6")),
    9 to Pair(listOf("1"), listOf("2")),
)

fun main() {
    val packagePath = "edu.mou.adventofcode"

    val reflections = Reflections(
        ConfigurationBuilder()
            .filterInputsBy(FilterBuilder().includePackage(packagePath))
            .setUrls(ClasspathHelper.forPackage(packagePath)).setScanners(Scanners.SubTypes)
    )

    println("## ADVENT OF CODE 2019 ##")
    println("-".repeat(30))

    val solvers = reflections
        .getSubTypesOf(DayProblem::class.java)
        .map { it.kotlin }
        .sortedBy { it.simpleName }
        .map { it.createInstance() }

    var totalTime = 0L

    solvers.forEachIndexed { index, instance ->
        val args = dayArguments[index + 1]

        val localTimeP1 = System.currentTimeMillis()
        val part1 = instance.solvePart1(*args?.first?.toTypedArray() ?: arrayOf())
        val endLocalTimeP1 = System.currentTimeMillis() - localTimeP1

        val localTimeP2 = System.currentTimeMillis()
        val part2 = instance.solvePart2(*args?.second?.toTypedArray() ?: arrayOf())
        val endLocalTimeP2 = System.currentTimeMillis() - localTimeP2

        println("#${instance.day} - ${instance.name}:")
        println("\t· Part 1 (${timeToString(endLocalTimeP1)}): $part1")
        println("\t· Part 2 (${timeToString(endLocalTimeP2)}): $part2")
        println("-".repeat(30))

        totalTime += endLocalTimeP1 + endLocalTimeP2
    }

    println("Total time: ${timeToString(totalTime)}")
}

fun timeToString(time: Long): String {
    val milliseconds = (time % 1000).toString().padStart(3, '0')
    val seconds = (time / 1000).toString().padStart(2, '0')
    val minutes = (time / 1000 / 60).toString().padStart(2, '0')

    return "${minutes}m ${seconds}s ${milliseconds}ms"
}