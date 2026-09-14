class Solution {
    public boolean exist(char[][] board, String word) {
        // 1. THE SCANNER: Radar sweeping every cell
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                
                // If the cell matches the first letter, drop the first worker!
                if (board[row][col] == word.charAt(0)) {
                    if (backtrack(board, word, row, col, 0)) {
                        return true; 
                    }
                }
            }
        }
        return false; 
    }

    private boolean backtrack(char[][] board, String word, int row, int col, int index) {
        // BASE CASE A: Success! We found every letter.
        if (index == word.length()) {
            return true;
        }

        // BASE CASE B: Failure! (Out of bounds OR wrong letter OR hit a '#' breadcrumb)
        if (row < 0 || row >= board.length || 
            col < 0 || col >= board[0].length || 
            board[row][col] != word.charAt(index)) {
            return false;
        }

        // A. CHOOSE: Lock the cell
        char temp = board[row][col]; 
        board[row][col] = '#';       

        // B. EXPLORE: Check all 4 directions, advancing the index by 1
        // The '||' (OR) means if ANY direction is true, it instantly stops checking the others!
        boolean found = backtrack(board, word, row - 1, col, index + 1) || // Up
                        backtrack(board, word, row + 1, col, index + 1) || // Down
                        backtrack(board, word, row, col - 1, index + 1) || // Left
                        backtrack(board, word, row, col + 1, index + 1);   // Right

        // C. UN-CHOOSE: Restore the cell for other timelines to use
        board[row][col] = temp;

        return found;
    }
}