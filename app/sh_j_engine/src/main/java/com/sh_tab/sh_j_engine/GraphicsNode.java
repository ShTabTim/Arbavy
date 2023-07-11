package com.sh_tab.sh_j_engine;

public class GraphicsNode extends SimpleNode {
    public float layer;
    protected Drawer drawer;
    protected Sprite sprite;

    public GraphicsNode(Class<? extends Node> parent, Drawer drawer) {
        super(parent);
        this.drawer = drawer;
    }

    public void draw() {

    }
}
