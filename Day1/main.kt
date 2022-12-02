import java.io.File;
import java.util.Queue;
import java.util.LinkedList;
import kotlin.math.max

fun main() {
    val fileName = "input.txt"
    val input: List<String>  = File(fileName).readLines()

    part1(input)
    part2(input)
}

fun part1(input: List<String>) {
    var max = 0
    var sum = 0
    for (line in input) {
        if (line.isEmpty()) {
            max = max(max, sum)
            sum = 0
        } else {
            sum += line.toInt()
        }
    }
    println("Part 1: $max")
}

fun part2(input: List<String>) {
    var elfCalores = ArrayList<Int>()
    var sum = 0
    for (line in input) {
        if (line.isEmpty()) {
            elfCalores.add(sum)
            sum = 0
        } else {
            sum += line.toInt()
        }
    }
    elfCalores.sort()
    val combinedCals = elfCalores[elfCalores.size-1] + elfCalores[elfCalores.size - 2] + elfCalores[elfCalores.size - 3]
    println("Part 2: $combinedCals")
}