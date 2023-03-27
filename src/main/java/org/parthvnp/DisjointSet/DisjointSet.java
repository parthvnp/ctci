package org.parthvnp.DisjointSet;

public class DisjointSet {
    public int[] weights;
    public int[] parents;
    public int size;

    public DisjointSet(int n) {
        weights = new int[n];
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = 1;
            parents[i] = i;
        }
    }

    public int find(int u) {
        while (parents[u] != u) {
            parents[u] = parents[parents[u]];
            u = parents[u];
        }
        return u;
    }

    public boolean union(int u, int v) {
        int root_u = find(u), root_v = find(v);
        if (root_u == root_v) return true;
        if (weights[root_u] > weights[root_v]) parents[root_v] = root_u;
        else if (weights[root_v] > weights[root_u]) parents[root_u] = root_v;
        else {
            parents[root_u] = root_v;
            weights[root_v]++;
        }
        size--;
        return false;
    }

    public int size() {
        return size;
    }

}
