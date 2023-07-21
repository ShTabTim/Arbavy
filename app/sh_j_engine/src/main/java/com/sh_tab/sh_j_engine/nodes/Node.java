package com.sh_tab.sh_j_engine.nodes;

import java.util.ArrayList;

public class Node extends SimpleNode {
    protected ArrayList<SimpleNode> children;
    protected int amountOfChildren;
    boolean internal_process;

    public Node(String name, Node parent) {
        super(name, parent);
        children = new ArrayList<SimpleNode>();
        amountOfChildren = 0;
    }

    public SimpleNode addChild(SimpleNode child) {
        if (child.parent == this) {
            return child;
        }
        if (child.parent != null) {
            child.parent.removeChild(child);
        }
        for(int i = 0; i < amountOfChildren; i++) {
            if (children.get(i) == null) {
                children.set(i, child);
                child.parent = this;
                return this;
            }
        }
        children.add(child);
        child.parent = this;
        amountOfChildren++;
        return child;
    }

    public SimpleNode eraseChild(SimpleNode child) {
        int id = children.indexOf(child);
        if(id >= 0) {
            children.set(id, null);
            child.parent = null;
            return child;
        }
        return null;
    }
    public SimpleNode removeChild(SimpleNode child) {
        if (children.remove(child)) {
            amountOfChildren--;
            child.parent = null;
            return child;
        }
        return null;
    }
}
