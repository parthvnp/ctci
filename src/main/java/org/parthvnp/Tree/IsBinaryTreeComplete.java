package org.parthvnp.Tree;

import java.util.*;

public class IsBinaryTreeComplete {
  public boolean isCompleteTree(TreeNode root) {
    return Math.abs(height(root.left) - height(root.right)) <= 1 && isComplete(root);
  }

  public int height(TreeNode root) {
    return root == null ? 0 : 1 + Math.max(height(root.left), height(root.right));
  }

  public boolean isComplete(TreeNode root) {
    boolean isNullNodeFound = false;
    if (root == null) return false;
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
      TreeNode curr = q.poll();
      if (curr == null) {
        isNullNodeFound = true;
        continue;
      } else if (isNullNodeFound) return false;
      q.add(curr.left);
      q.add(curr.right);
    }
    return true;
  }

  public static void main(String[] args) {
    var s = new IsBinaryTreeComplete();
    var root =
        new TreeNode(
            1,
            new TreeNode(2, new TreeNode(5), null),
            new TreeNode(3, new TreeNode(7), new TreeNode(8)));

    System.out.println(s.isCompleteTree(root));
  }
}
