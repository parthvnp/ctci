package org.parthvnp.Tree;

public class LevelOrderTraversalIterative<T> {
    public int height(TreeNode<T> root) {
        return root == null ? 0 : Math.max(height(root.left), height(root.right)) + 1;
    }

    public void LevelOrderTraversal(TreeNode root) {
        int h = height(root);
        for (int i = 1; i <= h; i++) {
            CurrentLevel(root, i);
            System.out.println();
        }
    }

    public void CurrentLevel(TreeNode root, int i) {
        if (root == null) {
            return;
        }
        if (i == 1) {
            System.out.print(root.value + " ");
        } else if (i > 1) {
            CurrentLevel(root.left, i - 1);
            CurrentLevel(root.right, i - 1);
        }
    }

    public static void main(String[] args) {
        var levelOrderTraversal = new LevelOrderTraversalIterative<Integer>();
        var root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        root.right.left = new TreeNode<>(6);
        root.right.right = new TreeNode<>(7);
        levelOrderTraversal.LevelOrderTraversal(root);

    }
}
