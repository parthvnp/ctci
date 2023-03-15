package org.parthvnp.Tree;

public class TreeTraversal {
    public static void inOrder(TreeNode node){
        if(node != null){
            inOrder(node.left);
            System.out.println(node.val);
            inOrder(node.right);
        }
    }

    public static void preOrder(TreeNode node){
        if(node != null){
            System.out.println(node.val);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public static void postOrder(TreeNode node){
        if(node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.val);
        }
    }

    public  static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode first = new TreeNode(2);
        TreeNode second = new TreeNode(3);
        root.left = first;
        root.right = second;
        inOrder(root);
        preOrder(root);
        postOrder(root);

    }
}
