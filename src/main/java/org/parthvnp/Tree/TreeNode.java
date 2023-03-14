package org.parthvnp.Tree;


public class TreeNode<T> {
    public T value;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode(T value) {
        this.value = value;
    }



    public void add(TreeNode<T> node, TreeNode<T> left, TreeNode<T> right) {
        node.left = left;
        node.right = right;
    }

    public TreeNode<T> FromArray(T[] values) {
        var nodes = (TreeNode<T>[])new Object[values.length];
        for(int i = 0; i < values.length; i++){
            nodes[i] = new TreeNode<T>(values[i]);
        }
        for(int i = 0; i < values.length; i++){
        }
        return null;
    }
}
