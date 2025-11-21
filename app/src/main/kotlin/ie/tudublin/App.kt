package ie.tudublin

import java.io.File
import java.io.IOException

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("Error: Please provide a file path as an argument.")
        return
    }

    val fileName = args[0]
    val file = File(fileName)

    if (!file.exists()) {
        println("Error: File '$fileName' not found.")
        return
    }

    try {
        val board = readBoardFromFile(file)
        println("Input Board:")
        printBoard(board)

        val solver = Sudoku(board)
        println("\nSolving...")
        
        if (solver.solve()) {
            println("Solution found:")
            printBoard(solver.getBoard())
        } else {
            println("Could not find a solution (or iteration limit reached).")
        }

    } catch (e: Exception) {
        println("Error processing file: ${e.message}")
    }
}

fun readBoardFromFile(file: File): Array<IntArray> {
    val lines = file.readLines()
    val board = Array(9) { IntArray(9) }

    for (i in 0 until 9) {
        if (i < lines.size) {
            // Split by comma, space, or just grab digits
            val numbers = lines[i].trim().split(Regex("[,\\s]+"))
            for (j in 0 until 9) {
                if (j < numbers.size) {
                    board[i][j] = numbers[j].toIntOrNull() ?: 0
                } else {
                    board[i][j] = 0
                }
            }
        }
    }
    return board
}

fun printBoard(board: Array<IntArray>) {
    for (i in board.indices) {
        if (i % 3 == 0 && i != 0) println("---------------------")
        for (j in board[i].indices) {
            if (j % 3 == 0 && j != 0) print("| ")
            print("${board[i][j]} ")
        }
        println()
    }
}