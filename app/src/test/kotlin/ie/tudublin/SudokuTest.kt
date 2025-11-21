package ie.tudublin

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SudokuTest {

    @Test
    fun testSolveSimpleBoard() {
        // A simple board that is solvable
        val grid = arrayOf(
            intArrayOf(5, 3, 0, 0, 7, 0, 0, 0, 0),
            intArrayOf(6, 0, 0, 1, 9, 5, 0, 0, 0),
            intArrayOf(0, 9, 8, 0, 0, 0, 0, 6, 0),
            intArrayOf(8, 0, 0, 0, 6, 0, 0, 0, 3),
            intArrayOf(4, 0, 0, 8, 0, 3, 0, 0, 1),
            intArrayOf(7, 0, 0, 0, 2, 0, 0, 0, 6),
            intArrayOf(0, 6, 0, 0, 0, 0, 2, 8, 0),
            intArrayOf(0, 0, 0, 4, 1, 9, 0, 0, 5),
            intArrayOf(0, 0, 0, 0, 8, 0, 0, 7, 9)
        )
        val sudoku = Sudoku(grid)
        assertTrue(sudoku.solve(), "Simple board should be solvable")
    }

    @Test
    fun testSolveHardBoard() {
        // A "Hard" board that is still solvable within the limit
        val grid = arrayOf(
            intArrayOf(0, 2, 0, 6, 0, 8, 0, 0, 0),
            intArrayOf(5, 8, 0, 0, 0, 9, 7, 0, 0),
            intArrayOf(0, 0, 0, 0, 4, 0, 0, 0, 0),
            intArrayOf(3, 7, 0, 0, 0, 0, 5, 0, 0),
            intArrayOf(6, 0, 0, 0, 0, 0, 0, 0, 4),
            intArrayOf(0, 0, 8, 0, 0, 0, 0, 1, 3),
            intArrayOf(0, 0, 0, 0, 2, 0, 0, 0, 0),
            intArrayOf(0, 0, 9, 8, 0, 0, 0, 3, 6),
            intArrayOf(0, 0, 0, 3, 0, 6, 0, 9, 0)
        )
        val sudoku = Sudoku(grid)
        assertTrue(sudoku.solve(), "Hard board should be solvable")
    }

 

    @Test
    fun testUnsolvableBoard() {
        // This board violates Sudoku rules (two 5s in the first row)
        // The solver should exhaust options or hit the iteration limit and return false
        val grid = arrayOf(
            intArrayOf(5, 5, 0, 0, 7, 0, 0, 0, 0), 
            intArrayOf(6, 0, 0, 1, 9, 5, 0, 0, 0),
            intArrayOf(0, 9, 8, 0, 0, 0, 0, 6, 0),
            intArrayOf(8, 0, 0, 0, 6, 0, 0, 0, 3),
            intArrayOf(4, 0, 0, 8, 0, 3, 0, 0, 1),
            intArrayOf(7, 0, 0, 0, 2, 0, 0, 0, 6),
            intArrayOf(0, 6, 0, 0, 0, 0, 2, 8, 0),
            intArrayOf(0, 0, 0, 4, 1, 9, 0, 0, 5),
            intArrayOf(0, 0, 0, 0, 8, 0, 0, 7, 9)
        )
        val sudoku = Sudoku(grid)
        assertFalse(sudoku.solve(), "Invalid board should not be solvable")
    }
}