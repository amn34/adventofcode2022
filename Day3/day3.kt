import java.io.File

// another solution using maps
fun main() {
    val fileName = "day3input.txt"
    val input: List<String>  = File(fileName).readLines()

    part1(input)
    part2(input)
}

fun part1(input: List<String>) {
    val sum = input.map { it.chunked(it.length / 2) }.sumOf { (a, b) ->
        val match = a.toSet().intersect(b.toSet()).iterator().next()
        if (match in 'a'..'z') {
            match - 'a' + 1
        } else {
            match - 'A' + 27
        }
    }

    println("Part 1 $sum")
}

fun part2(input: List<String>) {
    val sum = input.chunked(3).sumOf { (line1, line2, line3) ->
        val match = line1.toSet().intersect(line2.toSet()).intersect(line3.toSet()).iterator().next()
        if (match in 'a'..'z') {
            match - 'a' + 1
        } else {
            match - 'A' + 27
        }
    }

    println("Part 2: $sum")
}