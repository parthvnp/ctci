package org.parthvnp.Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class LevelOrderTraversalQueue<T> {
    public void LevelOrderTraversal(TreeNode<T> root){
        if(root == null){
            return;
        }
        Queue<TreeNode<T>> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            var node = queue.poll();
            System.out.println(node.value);
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        LevelOrderTraversalQueue<Integer> levelOrderTraversalQueue  = new LevelOrderTraversalQueue<>();
        var root = new TreeNode<>(8);
        root.left = new TreeNode<>(11);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        root.right.left = new TreeNode<>(6);
        root.right.right = new TreeNode<>(7);
        levelOrderTraversalQueue.LevelOrderTraversal(root);
    }
}
