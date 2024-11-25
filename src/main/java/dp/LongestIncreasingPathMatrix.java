package dp;

public class LongestIncreasingPathMatrix {
    public static int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int maxLength = 0;

        // Explore every cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maxLength = Math.max(maxLength, dfs(matrix, i, j, dp));
            }
        }

        return maxLength;
    }

    private static int dfs(int[][] matrix, int row, int col, int[][] dp) {
        if (dp[row][col] != 0) {
            return dp[row][col];
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxLength = 1;

        // Direction vectors for moving up, down, left, and right
        int[][] directions = {
                {0, 1}, {1, 0}, {0, -1}, {-1, 0}
        };

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            // Check if the new cell is valid and has a larger value
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                    && matrix[newRow][newCol] > matrix[row][col]) {
                int length = 1 + dfs(matrix, newRow, newCol, dp);
                maxLength = Math.max(maxLength, length);
            }
        }

        dp[row][col] = maxLength; // Store the result in the memoization table
        return maxLength;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };

        System.out.println("Longest Increasing Path: " + longestIncreasingPath(matrix));
        // Output: 4 (Path: 1 -> 2 -> 6 -> 9)
    }
}
