package org.parthvnp.Tree;

public class SmallestStringFromLeaf {
  String ans = "~";
  public String smallestFromLeaf(TreeNode root) {
    dfs(root, new StringBuilder());
    return ans;
  }

  public void dfs(TreeNode node, StringBuilder sb) {
    if (node == null) return;
    sb.append((char) ('a' + node.val));
    if (node.left == null && node.right == null) {
      sb.reverse();
      String S = sb.toString();
      sb.reverse();
      if (S.compareTo(ans) < 0) ans = S;
    }
    dfs(node.left, sb);
    dfs(node.right, sb);
    sb.deleteCharAt(sb.length() - 1);
  }

  public static void main(String[] args) {
    var s = new SmallestStringFromLeaf();
    var root = new TreeNode(0, new TreeNode(1), new TreeNode(2));
    var r = s.smallestFromLeaf(root);
    System.out.println(r);
  }
}