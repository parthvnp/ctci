package org.parthvnp.Graph;

import java.util.*;

public class CloneGraph {
    public static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }

        @Override
        public String toString() {
            return this.val + " - " + neighbors.toString();
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        var q = new ArrayDeque<Node>();
        var map = new HashMap<Integer, Node>();
        map.put(node.val, new Node(node.val));
        q.add(node);
        while (!q.isEmpty()) {
            var s = q.poll();
            for (var i : s.neighbors) {
                map.computeIfAbsent(i.val, k -> {
                    q.add(i);
                    return new Node(i.val);
                });
                map.get(s.val).neighbors.add(map.get(i.val));
            }
        }
        return map.get(node.val);
    }


    public void bfs(Node node) {
        var q = new ArrayDeque<Node>();
        var visited = new HashMap<Integer, Boolean>();
        q.add(node);
        visited.put(node.val, true);
        while (!q.isEmpty()) {
            var s = q.poll();
            System.out.println(s);
            visited.compute(s.val, (k, v) -> v == null || v);
            for (var i : s.neighbors) {
                if (visited.getOrDefault(i.val, false)) continue;
                q.add(i);
            }
        }
    }

    public static void main(String[] args) {
        var s = new CloneGraph();
        var first = new Node(1);
        var second = new Node(2);
        var third = new Node(3);
        var fourth = new Node(4);
        first.neighbors.add(second);
        first.neighbors.add(fourth);
        third.neighbors.add(second);
        first.neighbors.add(third);
        var g = s.cloneGraph(first);
        s.bfs(first);
        s.bfs(g);
    }
}
