import java.io.File

fun main() {
    val fileName = "day6input.txt"
    val input: List<String> = File(fileName).readLines()

    part1(input[0], 4)
    part1(input[0], 14)

}

fun part1(input: String, len: Int) {
    for (i in len until input.length) {
        if (containsDuplicate(input.substring(i-len, i), len)) {
            println("Part 1 $i")
            return
        }
    }
}

fun containsDuplicate(input: String, len: Int): Boolean {
    for (i in 0 until len) {
        for (j in 0 until len) {
            if (i != j) {
                if (input[i] == input[j]) {
                    return false
                }
            }
        }
    }
    return true
}

