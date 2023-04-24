package org.parthvnp.Heap;

import java.util.*;

public class WeakestRow {
    public static class Row implements Comparable<Row> {
        private final int[] row;
        private final int index;

        public Row(int[] row, int index) {
            this.row = row;
            this.index = index;
        }

        public int calcWeakness(int[] row) {
            int ans = 0;
            for (int i : row) ans += i;
            return ans;
        }

        public int compareTo(Row r) {
            int r1 = this.calcWeakness(this.row);
            int r2 = this.calcWeakness(r.row);
            if (r1 == r2) return this.index - r.index;
            return r1 - r2;
        }

    }

    public int[] kWeakestRows(int[][] mat, int k) {
        var minHeap = new PriorityQueue<Row>();
        for (int i = 0; i < mat.length; i++) minHeap.add(new Row(mat[i], i));
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            var r = minHeap.remove();
            ans[i] = r.index;
        }
        return ans;
    }


    public int[] kWeakestRows2(int[][] mat, int k){
        var minHeap = new PriorityQueue<int[]>((a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);
        int[] ans = new int[k];
        for(int i = 0; i < mat.length; i++){
            minHeap.add(new int[]{countOnes(mat[i]),i});
            if(minHeap.size() > k) minHeap.remove();
        }
        for(int i = k-1; i > -1; i--) ans[i] = minHeap.remove()[1];
        return ans;

    }

    public int countOnes(int[] row){
        int low = 0, high = row.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(row[mid] == 1) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }

    public static void main(String[] args) {
        var s = new WeakestRow();
        var e1 = s.kWeakestRows2(new int[][]{{1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}}, 3);
        System.out.println(Arrays.equals(e1, new int[]{2, 0, 3}));
        var e2 = s.kWeakestRows2(new int[][]{{1, 0, 0, 0},
                {1, 1, 1, 1},
                {1, 0, 0, 0},
                {1, 0, 0, 0}}, 2);
        System.out.println(Arrays.equals(e2, new int[]{0, 2}));

    }
}
