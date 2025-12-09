package org.example

import org.example.Day

object Day01 : Day(1) {
    override fun partOne(input: List<String>): String {
        var dial = 50
        var score = 0

    
        for (move in input) {
            var dir = 0
            if (move[0] == 'L') {
                dir = -1
            } else {
                dir = 1
            }

            var by = move.substring(1).toInt()
            if(by > 99) {
                by %= 100
            }

            dial += by * dir

            if (dial > 99) {
                dial %= 100
            } else if (dial < 0) {
                dial += 100
            }

            if (dial == 0) {
                score += 1
            }
        }

        return score.toString();
    }

    override fun partTwo(input: List<String>): String {
        var dial = 50
        var lastDial = dial
        var score = 0

    
        for (move in input) {
            var dir = 0
            if (move[0] == 'L') {
                dir = -1
            } else {
                dir = 1
            }

            var by = move.substring(1).toInt()
            if(by > 99) {
                score += (by / 100)
                by %= 100
            }

            lastDial = dial
            dial += by * dir

            if (dial > 99) {
                if(lastDial != 0) {
                    score += 1
                }
                dial %= 100
            } else if (dial < 0) {
                if(lastDial > 0) {
                    score += 1
                }
                dial += 100
            } else if (dial == 0) {
                score += 1
            }
        }

        return score.toString();
    }   

    
    override val testInput01: Map<List<String>, String> =
    mapOf(
        listOf(  
            "L68",
            "L30",
            "R48",
            "L5",
            "R60",
            "L55",
            "L1",
            "L99",
            "R14",
            "L82",
        ) to "3",
    )

    override val testInput02: Map<List<String>, String> =
    mapOf(
        listOf(  
            "L68",
            "L30",
            "R48",
            "L5",
            "R60",
            "L55",
            "L1",
            "L99",
            "R14",
            "L82",
        ) to "6",
    )
}
