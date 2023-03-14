package org.parthvnp.Array;

public class RotateMatrix {
    public static void Transpose(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = i; j < arr[0].length; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }

    public static void Reflect(int[][] arr){
        int c = arr[0].length;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < Math.floor(arr[0].length / 2); j++){
               var temp = arr[i][j];
               arr[i][j] = arr[i][c - j - 1];
               arr[i][c - j - 1] = temp;
            }
        }
    }
    public static void display(int[][] arr){
        for (int[] ints : arr) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void Rotate1(int[][] arr){
        Transpose(arr);
        Reflect(arr);
    }



    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        display(arr);
        Rotate1(arr);
        display(arr);
    }
}
