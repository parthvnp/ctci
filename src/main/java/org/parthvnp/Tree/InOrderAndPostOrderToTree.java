package org.parthvnp.Tree;

import java.util.*;

public class InOrderAndPostOrderToTree {
  public int[] inorder;
  public int[] postorder;
  public HashMap<Integer, Integer> inorder_idx_map;
  public int index;

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    this.inorder = inorder;
    this.postorder = postorder;
    this.inorder_idx_map = new HashMap<>();
    this.index = postorder.length - 1;
    for (int i = 0; i < inorder.length; i++) inorder_idx_map.put(inorder[i], i);
    return build(0, postorder.length - 1);
  }

  public TreeNode build(int low, int high) {
    if (low > high) return null;
    int rootVal = this.postorder[index];
    TreeNode root = new TreeNode(rootVal);
    this.index -= 1;
    int rootIdx = this.inorder_idx_map.get(rootVal);
    root.right = build(rootIdx + 1, high);
    root.left = build(low, rootIdx - 1);
    return root;
  }

  public static void main(String[] args) {
    var s = new InOrderAndPostOrderToTree();
    var inorder = new int[] {9, 3, 15, 20, 7};
    var postorder = new int[] {9, 15, 7, 20, 3};
    var r = s.buildTree(inorder, postorder);
    TreeNode.printPostorder(r);
  }
}
