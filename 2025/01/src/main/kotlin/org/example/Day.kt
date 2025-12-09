package org.example

abstract class Day(val number: Int) {
    abstract val testInput01: Map<List<String>, String>
    abstract val testInput02: Map<List<String>, String>

    abstract fun partOne(input: List<String>): String
    abstract fun partTwo(input: List<String>): String
}
