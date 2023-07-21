package com.sh_tab.sh_j_engine.nodes;

import com.sh_tab.sh_j_engine.shmath.vec2f;

public class CameraNode extends GraphicsNode{
    public vec2f center;
    public vec2f size;
    public CameraNode(String name, Node parent) {
        super(name, parent);
    }

}
