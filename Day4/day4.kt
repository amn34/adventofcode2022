import java.io.File

// another solution using maps
fun main() {
    val fileName = "day4input.txt"
    val input: List<String> = File(fileName).readLines()

    part1(input)
    part2(input)
}

fun part1(input: List<String>) {
    // split each line in the input on the comma e.g "3-5,5-7" -> ["3-5" , "5-7"]
    // then map to a pair containing a list of each of the numbers e.g. ["3-5" , "5-7"] -> Pair<["3", "5"], ["5", "7"]>
    val sum =
        input.map { it.split(",") }.map { Pair(it[0].split("-"), it[1].split("-")) }
            .sumBy {
                val firstPair = it.first
                val secondPair = it.second

                val firstPairRange = firstPair[0].toInt()..firstPair[1].toInt()
                val secondPairRange = secondPair[0].toInt()..secondPair[1].toInt()
                if (secondPair[0].toInt() in firstPairRange && secondPair[1].toInt() in firstPairRange) {
                    1 // sumBy
                } else if (firstPair[0].toInt() in secondPairRange && firstPair[1].toInt() in secondPairRange) {
                    1 // sumBy
                } else {
                    0 // sumBy
                }
            }
    println("Part 1: $sum")

    val sum2 = input.map {
        it.split(",")
            .map { pair -> pair.split("-").map { num -> num.toInt() } }
            .map { (from, to) -> (from..to).toSet() }
    }
        .map { (firstPair, secondPair) -> firstPair.containsAll(secondPair) or secondPair.containsAll(firstPair) }
        .count { it }
    println("Part 1-2: $sum2")
}

fun part2(input: List<String>) {
    val sum =
        input.map { it.split(",") }.map { Pair(it[0].split("-"), it[1].split("-")) }
            .sumBy {
                val firstPair = it.first
                val secondPair = it.second

                val firstPairRange = firstPair[0].toInt()..firstPair[1].toInt()
                val secondPairRange = secondPair[0].toInt()..secondPair[1].toInt()
                if (secondPair[0].toInt() in firstPairRange || secondPair[1].toInt() in firstPairRange) {
                    1 // sumBy
                } else if (firstPair[0].toInt() in secondPairRange || firstPair[1].toInt() in secondPairRange) {
                    1 // sumBy
                } else {
                    0 // sumBy
                }
            }
    println("Part 2: $sum")

    val sum2 = input.map {
        it.split(",")
            .map { pair -> pair.split("-").map { num -> num.toInt() } }
            .map { (from, to) -> (from..to).toSet() }
    }
        .map { (firstPair, secondPair) -> firstPair.intersect(secondPair).isNotEmpty() }.count { it }
    println("Part 2-2: $sum2")
}