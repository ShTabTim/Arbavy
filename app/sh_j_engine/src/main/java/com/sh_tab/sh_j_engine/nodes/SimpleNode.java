package com.sh_tab.sh_j_engine.nodes;

public class SimpleNode {
    public String name;
    public Node parent;
    public boolean process;
    //public boolean physical_process;
    //public boolean action_precess;
    //public boolean draw_process;
    public SimpleNode(String name, Node parent) {
        this.parent = parent;
        this.name = name;
        parent.addChild(this);
    }
    public void process(float dt) {

    }
}
