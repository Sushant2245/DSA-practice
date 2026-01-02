class Solution {

    // Check if queen can be placed at board[row][col]
    boolean isSafe(int[][] board, int row, int col, int n) {

        int r = row, c = col;

        // upper-left diagonal
        while (r >= 0 && c >= 0) {
            if (board[r][c] == 1) return false;
            r--; c--;
        }

        r = row; c = col;

        // left row
        while (c >= 0) {
            if (board[r][c] == 1) return false;
            c--;
        }

        r = row; c = col;

        // lower-left diagonal
        while (r < n && c >= 0) {
            if (board[r][c] == 1) return false;
            r++; c--;
        }

        return true;
    }

    void solve(int[][] board, int col, int n, List<List<String>> res) {
        if (col == n) {
            res.add(constructBoard(board, n));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 1;
                solve(board, col + 1, n, res);
                board[row][col] = 0; // backtrack
            }
        }
    }

    List<String> constructBoard(int[][] board, int n) {
        List<String> temp = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1)
                    sb.append('Q');
                else
                    sb.append('.');
            }
            temp.add(sb.toString());
        }

        return temp;
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[][] board = new int[n][n];
        solve(board, 0, n, res);
        return res;
    }
}
