package org.parthvnp.UnionFind;

public class SimilarStringGroups {
    class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++)
                parent[i] = i;
            rank = new int[size];
        }

        public int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        public void union_set(int x, int y) {
            int xset = find(x), yset = find(y);
            if (xset == yset) {
                return;
            } else if (rank[xset] < rank[yset]) {
                parent[xset] = yset;
            } else if (rank[xset] > rank[yset]) {
                parent[yset] = xset;
            } else {
                parent[yset] = xset;
                rank[xset]++;
            }
        }
    }

    public boolean isSimilar(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }
        return diff == 0 || diff == 2;
    }

    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        UnionFind dsu = new UnionFind(n);
        int count = n;
        // Form the required graph from the given strings array.
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSimilar(strs[i], strs[j]) && dsu.find(i) != dsu.find(j)) {
                    count--;
                    dsu.union_set(i, j);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        var s = new SimilarStringGroups();
        var e1 = s.numSimilarGroups(new String[]{"tars", "rats", "arts", "star"});
        System.out.println(e1 == 2);
        var e2 = s.numSimilarGroups(new String[]{"omv", "ovm"});
        System.out.println(e2 == 1);
        var e3 = s.numSimilarGroups(new String[]{"abc", "abc"});
        System.out.println(e3 == 1);
        var e4 = s.numSimilarGroups(new String[]{"abc", "cba"});
        System.out.println(e4 == 1);

    }
}
