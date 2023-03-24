package org.parthvnp.Graph;

import java.util.*;

public class TopologicalSort {
  public HashSet<Integer> visited = new HashSet<>();
  public Queue<Integer> ans = new ArrayDeque<>();

  public int[] Sort(int n, int[][] edges) {
    var map = construct(edges);
    for (int i = 0; i < n; i++) {
      if(!visited.contains(i)) dfs(i, map);
    }
    while(!ans.isEmpty()){
      System.out.println(ans.poll());
    }
    return new int[2];
  }

  public static HashMap<Integer, ArrayList<Integer>> construct(int[][] edges) {
    var map = new HashMap<Integer, ArrayList<Integer>>();
    for (int[] i : edges) {
      map.computeIfAbsent(i[1], k -> new ArrayList<>());
      map.computeIfPresent(
          i[1],
          (k, v) -> {
            v.add(i[0]);
            return v;
          });
    }
    return map;
  }

  public void dfs(int vertex, HashMap<Integer, ArrayList<Integer>> graph) {
    visited.add(vertex);
    for (int n : graph.getOrDefault(vertex, new ArrayList<>())) {
      if (!visited.contains(n)) dfs(n, graph);
    }
    ans.offer(vertex);
  }

  public static void main(String[] args) {
    var s = new TopologicalSort();
    s.Sort(5, new int[][]{new int[]{0,1},  new int[]{1,2}, new int[] {2,3}, new int[] {3,4}});
  }
}
