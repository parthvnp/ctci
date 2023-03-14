package org.parthvnp.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class GoodPaths {
    TreeNode<Integer > root;
    ArrayList<TreeNode<Integer>> nodes = new ArrayList<>();
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        // Construct the tree
        for(int i = 0; i < vals.length; i++){
            nodes.add(new TreeNode<>(vals[i]));
        }
        for(int i = 0; i < edges.length; i++){
            var parent = nodes.get(edges[i][0]);
            var child = nodes.get(edges[i][1]);
            if(parent.left == null){
                parent.left = child;
            }
            else{
                parent.right = child;
            }
        }
        root = nodes.get(0);
      return 0;
    }

    private void printTree(TreeNode<Integer> node){
        if(node != null){
            printTree(node.left);
            System.out.println(node.value);
            printTree(node.right);
        }
    }

   private void findAllPaths(TreeNode node){
       Queue<TreeNode<Integer>> queue = new ArrayDeque<>();
       queue.add(node);
       while(!queue.isEmpty()){

       }
   }

    public static void main(String[] args) {
        GoodPaths goodPaths = new GoodPaths();
        goodPaths.numberOfGoodPaths(new int[]{1, 3, 2, 1, 3}, new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{2, 3}, new int[]{2, 4}});
    }
}
