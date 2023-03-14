package org.parthvnp.Array;

import java.util.ArrayList;
import java.util.List;

public class ZeroMatrix {
    public static void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        ArrayList<List<Integer>> zeroes = new ArrayList<List<Integer>>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    zeroes.add(List.of(i, j));
                }
            }
        }
        for (var k : zeroes) {
            ZeroOutRow(matrix, k.get(0));
            ZeroOutColumn(matrix, k.get(1));
        }

    }

    public static void ZeroOutColumn(int[][] matrix, int column) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][column] = 0;
        }
    }

    public static void ZeroOutRow(int[][] matrix, int row) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[row][j] = 0;
        }
    }

    public static void setZeroes2(int[][] matrix) {
        boolean isFirstRow = false;
        boolean isFirstCol = false;
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < cols; i++) {
            if (matrix[0][i] == 0) {
                isFirstRow = true;
                break;
            }
        }

        for (int j = 0; j < rows; j++) {
            if (matrix[j][0] == 0) {
                isFirstCol = true;
                break;
            }
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i = 1; i < rows; i++){
            for(int j = 1; j < cols; j++){
                if(matrix[0][j] == 0 || matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(isFirstCol){
            for(int i = 0; i < rows; i++){
                matrix[i][0] = 0;
            }
        }
        if(isFirstRow){
            for(int j = 0; j < cols; j++){
                matrix[0][j] = 0;
            }
        }
    }


    public static void main(String[] args) {
        int[][] arr = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        RotateMatrix.display(arr);
        setZeroes2(arr);
        RotateMatrix.display(arr);

    }

}
