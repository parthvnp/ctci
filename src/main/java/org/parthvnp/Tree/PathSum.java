package org.parthvnp.Tree;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;

public class PathSum {
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

    public boolean isTargetFound = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        hasPathSumHelper(root, targetSum, new ArrayDeque<>());
        return isTargetFound;
    }

    public void hasPathSumHelper(TreeNode root, int targetSum, Deque<Integer> currSum) {
        if (root == null) return;
        currSum.push(root.val);
        if (root.left == null && root.right == null) {
            isTargetFound = isTargetFound || currSum.stream().reduce(0, Integer::sum) == targetSum;
        }
        hasPathSumHelper(root.left, targetSum, currSum);
        hasPathSumHelper(root.right, targetSum, currSum);
        currSum.removeFirst();
    }

    public static void main(String[] args) {
        var s = new PathSum();
        var root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        var r = s.hasPathSum(root, 4);
        System.out.println(r);
    }
}
