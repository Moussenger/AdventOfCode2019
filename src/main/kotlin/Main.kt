import edu.mou.adventofcode.tools.DayProblem
import org.reflections.Reflections
import org.reflections.scanners.Scanners
import org.reflections.util.ClasspathHelper
import org.reflections.util.ConfigurationBuilder
import org.reflections.util.FilterBuilder
import kotlin.reflect.full.createInstance

val dayArguments = mapOf<Int, Pair<List<String>?, List<String>?>>(
    2 to Pair(null, listOf("19690720"))
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

    val initialTime = System.currentTimeMillis()

    solvers.forEachIndexed { index, instance ->
        val args = dayArguments[index + 1]

        println("#${instance.day} - ${instance.name}:")
        println("\t· Part 1: ${instance.solvePart1(*args?.first?.toTypedArray() ?: arrayOf())}")
        println("\t· Part 2: ${instance.solvePart2(*args?.second?.toTypedArray() ?: arrayOf())}")
        println("-".repeat(30))
    }

    val endTime = System.currentTimeMillis() - initialTime

    val milliseconds = (endTime % 1000).toString().padStart(3, '0')
    val seconds = (endTime / 1000).toString().padStart(2, '0')
    val minutes = (endTime / 1000 / 60).toString().padStart(2, '0')

    println("Total time: ${minutes}m ${seconds}s ${milliseconds}ms")
}