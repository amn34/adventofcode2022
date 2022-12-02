import java.io.File

// another solution using maps
fun main() {
    val fileName = "input.txt"
    val input: List<String>  = File(fileName).readLines()

    part1(input)
    part2(input)
}

fun part1(input: List<String>) {
    var sum = input.map {
        when (it[0] to it[2]) {
            'A' to 'X' -> 1 + 3
            'A' to 'Y' -> 2 + 6
            'A' to 'Z' -> 3 + 0
            'B' to 'X' -> 1 + 0
            'B' to 'Y' -> 2 + 3
            'B' to 'Z' -> 3 + 6
            'C' to 'X' -> 1 + 6
            'C' to 'Y' -> 2 + 0
            'C' to 'Z' -> 3 + 3
            else -> 0
        }
    }.sum()

    println("Part 1: $sum")
}

fun part2(input: List<String>) {
    var sum = input.map {
        when (it[0] to it[2]) {
            'A' to 'X' -> 0 + 3
            'A' to 'Y' -> 3 + 1
            'A' to 'Z' -> 6 + 2
            'B' to 'X' -> 0 + 1
            'B' to 'Y' -> 3 + 2
            'B' to 'Z' -> 6 + 3
            'C' to 'X' -> 0 + 2
            'C' to 'Y' -> 3 + 3
            'C' to 'Z' -> 6 + 1
            else -> 0
        }
    }.sum()

    println("Part 2: $sum")
}