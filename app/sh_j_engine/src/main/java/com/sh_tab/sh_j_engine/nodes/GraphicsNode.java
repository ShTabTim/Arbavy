package com.sh_tab.sh_j_engine.nodes;

import com.sh_tab.sh_j_engine.shmath.mat2f;
import com.sh_tab.sh_j_engine.shmath.vec2f;

public class GraphicsNode extends SimpleNode {
    public vec2f pos = new vec2f();
    public mat2f mod = new mat2f();
    public GraphicsNode(String name, Node parent) {
        super(name, parent);
    }
}
