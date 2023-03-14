package org.parthvnp.Tree;

public class SortedArrayToBST {
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

        public static void show(TreeNode node) {
            show(node, "");
        }

        public static void show(TreeNode node, String sep) {
            if (node != null && node.left == null && node.right == null) {
                System.out.println(sep + node.val + " -- ");
            } else if (node != null) {
                System.out.println(sep + node.val);
                sep = sep + "\t";
                show(node.left, sep);
                show(node.right, sep);
            }

        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrToBST(int[] nums, int low, int high) {
        if (low > high) return null;
        if (low == high) return new TreeNode(nums[low]);
        int mid = low + (high - low) / 2;
        return new TreeNode(nums[mid], sortedArrToBST(nums, low, mid - 1), sortedArrToBST(nums, mid + 1, high));
    }

    public static void main(String[] args) {
        var s = new SortedArrayToBST();
        var n = s.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9, 11, 12});
        TreeNode.show(n);
    }
}
