package org.example

import java.io.File
import java.nio.file.Paths

object Main {
    public val days: Array<Day> = arrayOf(
        Day01
    )

    fun RunDay(day: Day) {
        val file = "inputs/${day.number.toString().padStart(2, '0')}.txt"
        val lines: List<String> = File(file).readLines()

        println("=== Day ${day.number} ===")
        println(">> Part One: ${day.partOne(lines)}")
        println(">> Part Two: ${day.partTwo(lines)}")
    }

    @JvmStatic
    fun main(args: Array<String>) {
        if(args.isNotEmpty()) {
            val num = args[0].toInt()
            val day = days.find { it.number == num }
            ?: error("Day #${num} not found :(")

            RunDay(day)
        } else {
            for (day in days) {
                RunDay(day)
            }
        }
    }

}
