package org.parthvnp.Tree;

public class MaxPathSum {
  public int max;

  public int maxPathSum(TreeNode root) {
    max = root.val;
    dfs(root);
    return max;
  }

  public int dfs(TreeNode root) {
    if (root == null) return 0;
    int left = Math.max(dfs(root.left), 0);
    int right = Math.max(dfs(root.right), 0);
    this.max = Math.max(this.max, root.val + left + right);
    return root.val + Math.max(left, right);
  }

  public static void main(String[] args) {
    var s = new MaxPathSum();
    var r = s.maxPathSum(new TreeNode(1));
    System.out.println(r);
  }
}
