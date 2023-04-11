package org.parthvnp.DFS;

import java.util.Arrays;

public class NumberOfEnclaves {
    public int numEnclaves(int[][] grid) {
        int count = 0;
        // convert all boundary 1s to 0s and all the 1s reachable from boundary to 0s
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i * j == 0 || i == grid.length - 1 || j == grid[0].length - 1) dfs(grid, i, j);
            }
        }
        // count the remaining 1s
        return Arrays.stream(grid).flatMapToInt(Arrays::stream).sum();
    }

    public void dfs(int[][] grid, int row, int col) {
        // if the current is out of bounds of not 1 then return
        if (row < 0 || col < 0 || row == grid.length || col == grid[0].length || grid[row][col] == 0) return;
        // the current cell is within bounds and is 1 so change it to 0
        grid[row][col] = 0;
        // now traverse in all the directions
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }

    public static void main(String[] args) {
        var s = new NumberOfEnclaves();
        var e1 = s.numEnclaves(new int[][]{{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}});
        System.out.println(e1 == 3);
    }
}
