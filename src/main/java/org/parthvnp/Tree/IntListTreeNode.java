package org.parthvnp.Tree;

import java.util.ArrayList;

public class IntListTreeNode {
    public int value;
    public ArrayList<IntListTreeNode> children = new ArrayList<>();
    public IntListTreeNode(int value){
        this.value = value;
    }

    public void add(IntListTreeNode node){
        children.add(node
        );
    }

}
