package org.parthvnp.Tree;

import java.util.HashMap;

public class BinaryTreeFromPreorderInorderTraversal {
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
    }

    public int preOrderIdx;
    public HashMap<Integer, Integer> inOrderIdxMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preOrderIdx = 0;
        for (int i = 0; i < inorder.length; i++) {
            inOrderIdxMap.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1);
    }

    private TreeNode build(int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }
        if (inStart == inEnd) {
            var l = new TreeNode(preorder[preOrderIdx]);
            preOrderIdx++;
            return l;
        }
        var rootVal = preorder[preOrderIdx];
        var rootIdx = inOrderIdxMap.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        preOrderIdx++;
        root.left = build(preorder, inStart, rootIdx - 1);
        root.right = build(preorder, rootIdx + 1, inEnd);
        return root;
    }
}
