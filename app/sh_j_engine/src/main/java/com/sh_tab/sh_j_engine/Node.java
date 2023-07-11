package com.sh_tab.sh_j_engine;

import java.util.ArrayList;

public class Node extends SimpleNode {
    ArrayList<Class<? extends SimpleNode>> children;

    public Node(Class<? extends Node> parent) {
        super(parent);
        children = new ArrayList<Class<? extends SimpleNode>>();
    }
}
