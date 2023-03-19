package org.parthvnp.Tree;

import java.util.*;

public class DescriptionToTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return show(this);
        }

        public static String show(TreeNode node) {
            var sb = new StringBuilder();
            show(node, "", sb);
            return sb.toString();
        }

        public static void show(TreeNode node, String sep, StringBuilder rep) {
            if (node != null) {
                rep.append(sep).append(node.val).append("\n");
                sep = sep + "\t";
                show(node.left, sep, rep);
                show(node.right, sep, rep);
            }

        }
    }

    public HashSet<Integer> findParents(int[][] descriptions) {
        var nodes = new HashSet<Integer>();
        for (var description : descriptions) nodes.add(description[0]);
        return nodes;
    }

    public HashSet<Integer> findChildren(int[][] descriptions) {
        var nodes = new HashSet<Integer>();
        for (var description : descriptions) nodes.add(description[1]);
        return nodes;
    }


    public HashMap<Integer, TreeNode> findNodes(int[][] description) {
        var nodes = new HashMap<Integer, TreeNode>();
        var parents = findParents(description);
        var children = findChildren(description);
        parents.addAll(children);
        for (var i : parents) nodes.put(i, new TreeNode(i));
        return nodes;
    }

    public Integer findRoot(HashSet<Integer> parents, HashSet<Integer> children) {
        parents.removeAll(children);
        return (Integer) parents.toArray()[0];
    }

    public void buildAncestry(int[][] description, HashMap<Integer, TreeNode> nodeIdxMap) {
        for (var d : description) {
            var parentNode = nodeIdxMap.get(d[0]);
            if (d[2] == 0) parentNode.right = nodeIdxMap.get(d[1]);
            else parentNode.left = nodeIdxMap.get(d[1]);
        }
    }

    public TreeNode createBinaryTree(int[][] description) {
        if (description.length == 0) return null;
        var root = findRoot(findParents(description), findChildren(description));
        var nodes = findNodes(description);
        buildAncestry(description, nodes);
        return nodes.get(root);
    }

    public TreeNode createBinaryTree2(int[][] description) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        HashSet<Integer> children = new HashSet<>();
        for (int[] i : description) {
            int parent = i[0], child = i[1], isLeft = i[2];
            var parentNode = map.getOrDefault(parent, new TreeNode(parent));
            children.add(child);
            if (isLeft == 1) {
                parentNode.left = map.getOrDefault(child, new TreeNode(child));
                map.put(child, parentNode.left);
            } else {
                parentNode.right = map.getOrDefault(child, new TreeNode(child));
                map.put(child, parentNode.right);
            }
            map.put(parent, parentNode);
        }
        TreeNode root = null;
        for (int[] j : description) {
            if (!children.contains(j[0])) {
                root = map.getOrDefault(j[0], null);
                break;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        // [[1,2,1],[2,3,0],[3,4,1]]
        int[][] descriptions = new int[][]{new int[]{1,2,1}, new int[]{2,3,0}, new int[]{3,4,1}};
        var s = new DescriptionToTree();
        var rootNode = s.createBinaryTree2(descriptions);
        System.out.println(rootNode);
    }
}
