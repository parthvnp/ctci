package org.parthvnp.Tree;

public class Tree2String {
    StringBuilder sb = new StringBuilder();
    public String tree2str(TreeNode node) {
       tree2StrHelper(node);
       return sb.toString();
    }

    public void tree2StrHelper(TreeNode node){
        if (node != null) {
            sb.append(node.val);
            if(node.left != null ){
                sb.append("(");
            }
            tree2str(node.left);
            tree2str(node.right);
            sb.append(")");
        }
    }

    public static void main(String[] args) {
        var s = new Tree2String();
        var root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.left.left = new TreeNode(4);
//        root.right = new TreeNode(3);
        s.tree2str(root);
        System.out.println(s.sb.toString());
    }
}
