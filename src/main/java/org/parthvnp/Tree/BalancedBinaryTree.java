package org.parthvnp.Tree;

public class BalancedBinaryTree {

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
    public static boolean isB;
   public boolean isBalanced(TreeNode root){
      isB = true;
      bHeight(root);
      return isB;
   }

   public int bHeight(TreeNode node){
       if(node == null){
           return 0;
       }
       int leftSubtreeDepth = bHeight(node.left );
       int rightSubtreeDepth = bHeight(node.right);
       if(Math.abs(leftSubtreeDepth - rightSubtreeDepth) > 1  ){
           isB = false;
       }
       return 1 + Math.max(leftSubtreeDepth, rightSubtreeDepth);
   }
   
   public int height(TreeNode root){
        if(root == null){return 0;}
        return Math.max(1 + height(root.left), 1+ height(root.right));
   }

    public static void main(String[] args) {

    }
}
