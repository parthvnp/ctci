package org.parthvnp.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        var ans = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if(root == null){
            return ans;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            int i = 1;
            int size = queue.size();
            var res = new ArrayList<Integer>();
            while (i <= size) {
               var curr = queue.poll();
               res.add(curr.val);
               if(curr.left != null){
                   queue.add(curr.left);
               }
               if(curr.right != null){
                   queue.add(curr.right);
               }
               i++;
            }
            ans.add(res);
        }

        return ans;
    }

    public static void main(String[] args) {
        var root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        var levelOrder = new LevelOrderTraversal();
        System.out.println(levelOrder.levelOrder(root));
    }
}
