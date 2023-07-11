package com.sh_tab.sh_j_engine;

public abstract class SimpleNode {
    public float x = 0;
    public float y = 0;

    public boolean show;
    public boolean exists;
    protected Node parent;

    Node getParent() {
        return parent;
    }
    void setParent(Node parent) {
        this.parent = parent;
    }

    public SimpleNode(Node parent) {
        this.parent = parent;
    }

    public float getX() {
        return ((parent == null) ? x : (x + parent.getX()));
    }
    public float getY() {
        return ((parent == null) ? y : (y + parent.getY()));
    }
}
