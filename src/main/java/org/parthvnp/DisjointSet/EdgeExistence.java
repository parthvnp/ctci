package org.parthvnp.DisjointSet;
import java.util.*;

public class EdgeExistence {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        int M = edgeList.length, N = queries.length;
        var dsu = new DisjointSet(n);
        for (int i = 0; i < queries.length; i++)
            queries[i] = new int[]{queries[i][0], queries[i][1], queries[i][2], i};
        Arrays.sort(queries, Comparator.comparingInt(a -> a[2]));
        Arrays.sort(edgeList, Comparator.comparingInt(a -> a[2]));
        boolean[] res = new boolean[N];
        for (int i = 0, j = 0; i < N; i++) {
            int[] query = queries[i];
            while (j < M && edgeList[j][2] < queries[i][2])
                dsu.union(edgeList[j][0], edgeList[j++][1]);
            res[queries[i][3]] = dsu.find(queries[i][0]) == dsu.find(queries[i][1]);
        }
        return res;
    }

    public static void main(String[] args) {
        var s = new EdgeExistence();
        int n = 3;
        int[][] edgeList = {{0, 1, 2}, {1, 2, 4}, {2, 0, 8}, {1, 0, 16}};
        int[][] queries = {{0, 1, 2}, {0, 2, 5}};
        var e1 = s.distanceLimitedPathsExist(n, edgeList, queries);
        System.out.println(Arrays.toString(e1));
        System.out.println(Arrays.equals(e1, new boolean[]{false, true}));
    }
}
