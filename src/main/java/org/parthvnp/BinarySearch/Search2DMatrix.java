package org.parthvnp.BinarySearch;

public class Search2DMatrix {
  public boolean searchMatrix(int[][] matrix, int target) {
    // find the row where the value could be since values in row above will always be less than the
    // values in the row below.
    // the bounds will 0, matrix[0].length - 1
    // inspect the ends of each row. If the target lies between
    // matrix[r][col_left] <= target <= matrix[r][col_left], we have found the row. Then perform
    // binary search within this row
    int top = 0,
        bottom = matrix.length - 1,
        left_col = 0,
        right_col = matrix[0].length - 1,
        row = -1;
    while (top <= bottom) {
      int mid = top + (bottom - top) / 2;
      if (matrix[mid][left_col] <= target && target <= matrix[mid][right_col]) {
        row = mid;
        break;
      }
      if (target > matrix[mid][right_col]) top = mid + 1;
      else bottom = mid - 1;
    }
    if (row == -1) return false;
    int[] arrayToSearch = matrix[row];
    int left = 0, right = arrayToSearch.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (arrayToSearch[mid] == target) return true;
      if (target > arrayToSearch[mid]) left = mid + 1;
      else right = mid - 1;
    }
    return false;
  }

  public static void main(String[] args) {
    var s = new Search2DMatrix();
    var e1 = s.searchMatrix(new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3);
    System.out.println(e1);
    var e2 = s.searchMatrix(new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 13);
    System.out.println(e2);
    var e3 = s.searchMatrix(new int[][] {{1}}, 0);
    System.out.println(e3);
    var e4 = s.searchMatrix(new int[][] {{1, 3}}, 3);
    System.out.println(e4);
    var e5 = s.searchMatrix(new int[][] {{1, 3}}, 2);
    System.out.println(e5);
  }
}
