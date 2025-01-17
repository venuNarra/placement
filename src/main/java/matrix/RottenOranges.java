package matrix;

import java.util.*;

public class RottenOranges {

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;

        int rows = grid.length;
        int cols = grid[0].length;
        int freshCount = 0;
        Queue<int[]> queue = new LinkedList<>();

        // Step 1: Initialize the queue with all rotten oranges and count fresh ones
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c}); // Add rotten orange to the queue
                } else if (grid[r][c] == 1) {
                    freshCount++; // Count fresh oranges
                }
            }
        }

        if (freshCount == 0) return 0; // No fresh oranges to rot

        // Directions for adjacent cells (up, down, left, right)
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int minutes = 0;

        // Step 2: Perform BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottedThisMinute = false;

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0], y = current[1];

                for (int[] dir : directions) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    // Check if the adjacent cell is valid and contains a fresh orange
                    if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2; // Mark as rotten
                        queue.offer(new int[]{newX, newY}); // Add to the queue
                        freshCount--;
                        rottedThisMinute = true;
                    }
                }
            }

            if (rottedThisMinute) {
                minutes++;
            }
        }

        // Step 3: Check if any fresh oranges are left
        return freshCount == 0 ? minutes : -1;
    }

    public static void main(String[] args) {
        RottenOranges solution = new RottenOranges();
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        int result = solution.orangesRotting(grid);
        System.out.println("Minimum time to rot all oranges: " + result);
    }
}
