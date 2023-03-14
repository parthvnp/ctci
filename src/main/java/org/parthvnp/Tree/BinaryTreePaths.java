package org.parthvnp.Tree;

import java.util.*;
public class BinaryTreePaths {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public List<String> binaryTreePaths(TreeNode root) {
        var l = new ArrayList<String>();
        binaryTreePaths(root, l, new ArrayDeque<>());
        return l;
    }

    public void binaryTreePaths(TreeNode root, ArrayList<String> list, Deque<String> curr){
        if(root == null) return;
        curr.add(String.valueOf(root.val));
        if(root.left == null && root.right == null) list.add(String.join("->", curr));
        binaryTreePaths(root.left, list, curr);
        binaryTreePaths(root.right, list, curr);
        curr.removeLast();
    }

    public static void main(String[] args) {
        var s = new BinaryTreePaths();
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        System.out.println(s.binaryTreePaths(root));

    }
}
