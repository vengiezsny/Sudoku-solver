package ie.tudublin

class Sudoku(private val board: Array<IntArray>) {

    private val size = 9
    private var iterations = 0
    private val maxIterations = 2_000_000

    fun solve(): Boolean {
        iterations = 0
        return solveBoard()
    }

    private fun solveBoard(): Boolean {
        // Check iteration limit
        iterations++
        if (iterations > maxIterations) {
            return false
        }

        for (row in 0 until size) {
            for (col in 0 until size) {
                // If the cell is empty (0)
                if (board[row][col] == 0) {
                    for (num in 1..9) {
                        if (isValid(row, col, num)) {
                            board[row][col] = num

                            if (solveBoard()) {
                                return true
                            } else {
                                // Backtrack
                                board[row][col] = 0
                            }
                        }
                    }
                    return false
                }
            }
        }
        return true
    }

    private fun isValid(row: Int, col: Int, num: Int): Boolean {
        // Check row
        for (i in 0 until size) {
            if (board[row][i] == num) return false
        }

        // Check column
        for (i in 0 until size) {
            if (board[i][col] == num) return false
        }

        // Check 3x3 subgrid
        val startRow = row - row % 3
        val startCol = col - col % 3
        for (i in 0 until 3) {
            for (j in 0 until 3) {
                if (board[i + startRow][j + startCol] == num) return false
            }
        }

        return true
    }

    // Helper to get a copy of the board (useful for tests)
    fun getBoard(): Array<IntArray> {
        return board
    }
}