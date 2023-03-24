package org.parthvnp.Graph;

import java.util.*;
import java.util.stream.IntStream;

public class MinReorder {
  public int count = 0;
  public HashSet<Integer> visited = new HashSet<>();

  public int minReorder(int n, int[][] connections) {
    var adj = buildAdjacencyList(n, connections);
    dfs(0, adj);
    return count;
  }

  public static HashMap<Integer, List<int[]>> buildAdjacencyList(int n, int[][] connections) {
    HashMap<Integer, List<int[]>> adj = new HashMap<>();
    IntStream.range(0, n).forEach(i -> adj.put(i, new ArrayList<>()));

    for (int[] connection : connections) {
      int i = connection[0], j = connection[1];
      adj.computeIfAbsent(j, k -> new ArrayList<>()).add(new int[] {i, 0});
      adj.computeIfAbsent(i, k -> new ArrayList<>()).add(new int[] {j, 1});
    }

    return adj;
  }

  public void dfs(int vertex, HashMap<Integer, List<int[]>> adj) {
    visited.add(vertex);
    for (var i : adj.get(vertex)) {
      if (!visited.contains(i[0])) {
        count += i[1];
        dfs(i[0], adj);
      }
    }
  }

  public static void main(String[] args) {
    var s = new MinReorder();
    var r = s.minReorder(
        5,
        new int[][] {
          {0, 1},
          {1, 3},
          {2, 3},
          {4, 0},
          {4, 5}
        });
    System.out.println(r);
  }
}
