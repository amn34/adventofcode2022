import java.io.File

fun main() {
    val fileName = ".txt"
    val input: List<String>  = File(fileName).readLines()

    part1(input)
    part2(input)
}

fun part1(input: List<String>) {
    var sum = 0

    val rock = 'X'
    val paper = 'Y'
    val scissors = 'Z'

    val rockMap = hashMapOf(rock to 3, paper to 6, scissors to 0)
    val paperMap = hashMapOf(rock to 0, paper to 3, scissors to 6)
    val scissorsMap = hashMapOf(rock to 6, paper to 0, scissors to 3)

    val scoresMap = hashMapOf('A' to rockMap, 'B' to paperMap, 'C' to scissorsMap)
    val inputMap = hashMapOf(rock to 1, paper to 2, scissors to 3)

    for (line in input) {
        sum += scoresMap.getValue(line[0]).getValue(line[2])
        sum += inputMap.getValue(line[2])
    }
    println("Part 1: $sum")
}

fun part2(input: List<String>) {
    var sum = 0

    val lose = 'X'
    val tie = 'Y'
    val win = 'Z'

    val rockMap = hashMapOf(lose to 3, tie to 1, win to 2)
    val paperMap = hashMapOf(lose to 1, tie to 2, win to 3)
    val scissorsMap = hashMapOf(lose to 2, tie to 3, win to 1)

    val choiceMap = hashMapOf('A' to rockMap, 'B' to paperMap, 'C' to scissorsMap)
    val outcomeMap = hashMapOf(lose to 0, tie to 3, win to 6)

    for (line in input) {
        sum += choiceMap.getValue(line[0]).getValue(line[2])
        sum += outcomeMap.getValue(line[2])
    }
    println("Part 2: $sum")
}