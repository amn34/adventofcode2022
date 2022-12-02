import java.io.File;
import java.util.Queue;
import java.util.LinkedList;

fun main() {
    val fileName = "input.txt"
    val input: List<String>  = File(fileName).readLines()

    part1(input)
    part2(input)
}

fun part1(input: List<String>) {
    var sum: Int = 0
    var last: Int = input.get(0).toInt()
    for (i in 1..input.size-1) {
        var current: Int = input.get(i).toInt()
        if (last < current) sum++
        last = current;
    }
    println("Part 1: " + sum)
} 

fun part2(input: List<String>) {
    val queue: Queue<Int> = LinkedList<Int>()
    var first: Int = input.get(0).toInt()
    var second: Int = input.get(1).toInt()
    var third: Int  = input.get(2).toInt()
    var prevSum: Int = first + second + third
    var count = 0
    queue.add(first)
    queue.add(second)
    queue.add(third)

    for (i in 3..input.size-1) {
        val current = input.get(i).toInt()
        val sum: Int = prevSum - queue.remove() + current
        if (prevSum < sum) count++
        prevSum = sum
        queue.add(current)
    }

    println("Part 2: " + count )
}