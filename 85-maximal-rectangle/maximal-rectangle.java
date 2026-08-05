class Solution {

    int maxArea = 0;

    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        solve(matrix, 0, 0, m, n);

        return maxArea;
    }

    private void solve(char[][] matrix, int row, int col, int m, int n) {

        if (row == m)
            return;

        if (col == n) {
            solve(matrix, row + 1, 0, m, n);
            return;
        }

        if (matrix[row][col] == '1') {
            int minWidth = Integer.MAX_VALUE;

            for (int i = row; i < m && matrix[i][col] == '1'; i++) {
                int width = 0;
                while (col + width < n && matrix[i][col + width] == '1') {
                    width++;
                }

                minWidth = Math.min(minWidth, width);
                maxArea = Math.max(maxArea, minWidth * (i - row + 1));
            }
        }

        solve(matrix, row, col + 1, m, n);
    }
}