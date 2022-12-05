import java.io.File
import java.util.Stack

// another solution using maps
fun main() {
    val fileName = "day5input.txt"
    val input: List<String> = File(fileName).readLines()

    part1(input)
    println()
    part2(input)
}

fun part1(input: List<String>) {
    val col1 = ArrayDeque(listOf('R', 'G', 'H', 'Q', 'S', 'B', 'T', 'N'))
    val col2 = ArrayDeque(listOf('H', 'S', 'F', 'D', 'P', 'Z', 'J'))
    val col3 = ArrayDeque(listOf('Z', 'H', 'V'))
    val col4 = ArrayDeque(listOf('M', 'Z', 'J', 'F', 'G', 'H'))
    val col5 = ArrayDeque(listOf('T', 'Z', 'C', 'D', 'L', 'M', 'S', 'R'))
    val col6 = ArrayDeque(listOf('M', 'T', 'W', 'V', 'H', 'Z', 'J'))
    val col7 = ArrayDeque(listOf('T', 'F', 'P', 'L', 'Z'))
    val col8 = ArrayDeque(listOf('Q', 'V', 'W', 'S'))
    val col9 = ArrayDeque(listOf('W', 'H', 'L', 'M', 'T', 'D', 'N', 'C'))

    val cols = listOf(col1, col2, col3, col4, col5, col6, col7, col8, col9)

    input.map { it.replace("move", "").replace("from", ".").replace("to", ".").replace(" ", "").split(".") }
        .map { Triple(it[0].toInt(), it[1].toInt(), it[2].toInt()) }.forEach {
            val numMove = it.first
            val src = it.second - 1
            val dest = it.third - 1
            for (i in 1..numMove) {
                cols[dest].addLast(cols[src].removeLast())
            }
        }
    for (col in cols) {
        print(col.last())
    }
}

fun part2(input: List<String>) {
    val col1 = ArrayDeque(listOf('R', 'G', 'H', 'Q', 'S', 'B', 'T', 'N'))
    val col2 = ArrayDeque(listOf('H', 'S', 'F', 'D', 'P', 'Z', 'J'))
    val col3 = ArrayDeque(listOf('Z', 'H', 'V'))
    val col4 = ArrayDeque(listOf('M', 'Z', 'J', 'F', 'G', 'H'))
    val col5 = ArrayDeque(listOf('T', 'Z', 'C', 'D', 'L', 'M', 'S', 'R'))
    val col6 = ArrayDeque(listOf('M', 'T', 'W', 'V', 'H', 'Z', 'J'))
    val col7 = ArrayDeque(listOf('T', 'F', 'P', 'L', 'Z'))
    val col8 = ArrayDeque(listOf('Q', 'V', 'W', 'S'))
    val col9 = ArrayDeque(listOf('W', 'H', 'L', 'M', 'T', 'D', 'N', 'C'))

    val cols = listOf(col1, col2, col3, col4, col5, col6, col7, col8, col9)

    input.map { it.replace("move", "").replace("from", ".").replace("to", ".").replace(" ", "").split(".") }
        .map { Triple(it[0].toInt(), it[1].toInt(), it[2].toInt()) }.forEach {
            val numMove = it.first
            val src = it.second - 1
            val dest = it.third - 1
            val temp = ArrayDeque<Char>()
            for (i in 1..numMove) {
                temp.addFirst(cols[src].removeLast())
            }
            for (letter in temp) {
                cols[dest].addLast(letter)
            }
        }
    for (col in cols) {
        print(col.last())
    }
}