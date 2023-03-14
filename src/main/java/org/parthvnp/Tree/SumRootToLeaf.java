package org.parthvnp.Tree;

import java.util.*;

public class SumRootToLeaf {
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

    public int s = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, new ArrayList<>());
        return s;
    }

    public void dfs(TreeNode root, ArrayList<Integer> vals) {
        if (root == null) return;
        vals.add(root.val);
        if (root.left == null && root.right == null) s += computeSum(vals);
        dfs(root.left, vals);
        dfs(root.right, vals);
        vals.remove(vals.size() - 1);
    }

    public int computeSum(ArrayList<Integer> vals) {
        int sum = 0, n = vals.size();
        for (int i = 0; i < vals.size(); i++) sum += (int) Math.pow(10, n - i - 1) * vals.get(i);
        return sum;
    }

    public static void main(String[] args) {
        var s = new SumRootToLeaf();
        var root = new TreeNode(1, new TreeNode(2),  new TreeNode(3));
        var r = s.sumNumbers(root);
        System.out.println(r);

    }
}
