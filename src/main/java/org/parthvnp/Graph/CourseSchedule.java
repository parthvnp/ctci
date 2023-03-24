package org.parthvnp.Graph;

import java.util.*;

public class CourseSchedule {
  public HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
  public int[] visited;

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    visited = new int[numCourses];
    construct(prerequisites);
    for (int i = 0; i < numCourses; i++) if (hasCycle(i)) return false;
    return true;
  }

  public void construct(int[][] prereqs) {
    for (int[] i : prereqs) {
      graph.computeIfAbsent(i[1], k -> new ArrayList<>());
      graph.computeIfPresent(
          i[1],
          (k, v) -> {
            v.add(i[0]);
            return v;
          });
    }
  }

  public boolean hasCycle(int index) {
    if (visited[index] == 1) return false;
    if (visited[index] == -1) return true;
    visited[index] = -1;
    for (int i : graph.getOrDefault(index, new ArrayList<>())) {
      if (hasCycle(i)) return true;
    }
    visited[index] = 1;
    return false;
  }

  public static void main(String[] args) {
    var s = new CourseSchedule();
    var r = s.canFinish(2, new int[][]{new int[]{1,0}});
    System.out.println(s.graph);
    System.out.println(r);
  }
}
