package org.parthvnp.Array;

import java.util.*;

public class SpiralOrder {
    public List<Integer> spiralOrderDualMovement(int[][] matrix) {
        List<Integer> output = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int direction = 1;
        int i = 0, j = -1;
        while (m * n > 0) {
            for (int k = 0; k < n; k++) {
                j += direction;
                output.add(matrix[i][j]);
            }
            m -= 1;
            for (int l = 0; l < m; l++) {
                i += direction;
                output.add(matrix[i][j]);
            }
            n -= 1;
            direction *= -1;
        }
        return output;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        // four cases
        // case 1: start from top left and go to top right, then increment the top by 1 as the top most row has been fully traversed
        // case 2: go from top to bottom and then decrement right by 1 as the right has been fully traversed
        // case 3: go from bottom right to bottom left and then decrement the bottom as the bottom most has been fully visited
        // case 4: go from bottom to top then increment the left by 1 as the left most column has been fully traversed
        List<Integer> output = new ArrayList<>();
        int dir = 1;
        int row = matrix.length, column = matrix[0].length;
        int top = 0, bottom = row - 1, left = 0, right = column - 1;
        while (top <= bottom && left <= right) {
            // top left to top right
            if (dir == 1) {
                for (int i = left; i <= right; i++) output.add(matrix[top][i]);
                top++;
                dir = 2;
                // top right to bottom right
            } else if (dir == 2) {
                for (int i = top; i <= bottom; i++) output.add(matrix[i][right]);
                right--;
                dir = 3;
            }
            // bottom right to bottom left
            else if (dir == 3) {
                for (int i = right; i >= left; i--) output.add(matrix[bottom][i]);
                bottom--;
                dir = 4;
            }
            // bottom right to top right;
            else {
                for (int i = bottom; i >= top; i--) output.add(matrix[i][left]);
                left++;
                dir = 1;
            }
        }

        return output;
    }

    public List<Integer> spiralOrderRecursive()

    public static void main(String[] args) {
        var s = new SpiralOrder();
        var e1 = s.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        System.out.println(e1.equals(Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5)));
        var e2 = s.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});
        System.out.println(e2.equals(Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7)));
        var e3 = s.spiralOrder(new int[][]{{1}});
        System.out.println(e3.equals(List.of(1)));
        var e4 = s.spiralOrder(new int[][]{{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}});
        System.out.println(e4.equals(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        var e5 = s.spiralOrder(new int[][]{{1}, {2}, {3}, {4}, {5}, {6}, {7}, {8}, {9}, {10}});
        System.out.println(e5.equals(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        var e6 = s.spiralOrder(new int[][]{{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15, 16, 17, 18, 19, 20}});
        System.out.println(e6.equals(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20,
                19, 18, 17, 16, 15, 14, 13, 12, 11)));
        var e7 = s.spiralOrder(new int[][]{{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15, 16, 17, 18, 19, 20}, {21, 22, 23, 24, 25, 26, 27, 28, 29, 30}});
        System.out.println(e7.equals(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 30, 29, 28,
                27, 26, 25, 24, 23, 22, 21, 11, 12, 13, 14, 15, 16, 17, 18, 19)));


    }
}
