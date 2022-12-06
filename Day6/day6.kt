import java.io.File

fun main() {
    val fileName = "day6input.txt"
    val input: List<String> = File(fileName).readLines()

    solve(input[0], 4)
    solve(input[0], 14)

    solve2(input[0], 4)
    solve2(input[0], 14)

    solve3(input[0], 4)
    solve3(input[0], 14)
}

fun solve(input: String, len: Int) {
    for (i in len until input.length) {
        if (containsDuplicate(input.substring(i-len, i), len)) {
            println("Solution $i")
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

fun solve2(input: String, len: Int) {
    for (i in 0 until input.length - len) {
        if (containsDuplicate2(input, i, len)) {
            println("Solution 2: ${i+len}")
            return
        }
    }
}

fun containsDuplicate2(input: String, start: Int, len: Int): Boolean {
    val set = HashSet<Char>()
    for (i in start until start + len) {
        set.add(input[i])
    }
    return set.size == len
}


fun solve3(input: String, len: Int) {
    val index = input.windowed(len).indexOfFirst {it.toSet().size == len} + len
    println("Solution 3: $index")
}