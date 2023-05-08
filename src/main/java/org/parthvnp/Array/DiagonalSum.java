package org.parthvnp.Array;

public class DiagonalSum {
    public int diagonalSum(int[][] mat) {
        int primary = 0, secondary = 0, n = mat.length;
        for(int i = 0; i < n; i++){
            primary += mat[i][i];
            secondary += i == n - i - 1 ? 0 : mat[i][n-i-1];
        }
        return primary + secondary;
    }

    public static void main(String[] args) {
        var s = new DiagonalSum();
        var e1 = s.diagonalSum(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
        System.out.println(e1 == 25);
        var e2 = s.diagonalSum(new int[][]{{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}});
        System.out.println(e2 == 8);
        var e3 = s.diagonalSum(new int[][]{{5}});
        System.out.println(e3 == 5);
    }
}
