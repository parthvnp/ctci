package org.parthvnp.Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DuplicateSubtrees {
    HashMap<String, Integer> res = new HashMap<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        var res = new ArrayList<TreeNode>();
        var map = new HashMap<String, Integer>();
        serialize(root, map, res);
        return res;
    }

    public String serialize(TreeNode root, HashMap<String, Integer> map, List<TreeNode> res){
        if(root == null){
            return "#";
        }
        var path = root.val + serialize(root.left, map, res) + serialize(root.right, map, res);
        map.compute(path, (k,v) -> v == null ? 1 : ++v);
        if(map.get(path) == 2) res.add(root);
        return path;
    }

    public static void main(String[] args) {
        var s = new DuplicateSubtrees();
        var root = new TreeNode(1);
        root.left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        root.right = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        System.out.println(s.findDuplicateSubtrees(root));
    }
}
