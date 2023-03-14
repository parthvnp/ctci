package org.parthvnp.Tree;

public class TreeTraversal {
    public static void inOrder(TreeNode node){
        if(node != null){
            inOrder(node.left);
            System.out.println(node.value);
            inOrder(node.right);
        }
    }

    public static void preOrder(TreeNode node){
        if(node != null){
            System.out.println(node.value);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public static void postOrder(TreeNode node){
        if(node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.value);
        }
    }

    public  static void main(String[] args) {

        TreeNode root = new TreeNode("B");
        TreeNode first = new TreeNode("A");
        TreeNode second = new TreeNode("C");
        root.left = first;
        root.right = second;
        inOrder(root);
        preOrder(root);
        postOrder(root);

    }
}
