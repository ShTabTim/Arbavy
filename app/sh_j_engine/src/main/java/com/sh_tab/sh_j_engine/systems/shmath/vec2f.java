package com.sh_tab.sh_j_engine.systems.shmath;

public class vec2f {
    public float x0, x1;
    public vec2f(float x0, float x1) {
        this.x0 = x0;
        this.x1 = x1;
    }
    public vec2f() {
        this(0, 0);
    }
    public vec2f cpy() {
        return new vec2f(x0, x1);
    }
    public vec2f add(vec2f o) {
        x0 += o.x0;
        x1 += o.x1;
        return this;
    }
    public vec2f inv() {
        x0 = -x0;
        x1 = -x1;
        return this;
    }
    public vec2f scl(double s) {
        x0 *= s;
        x1 *= s;
        return this;
    }
    public vec2f scl(float s) {
        x0 *= s;
        x1 *= s;
        return this;
    }
    public vec2f scl(int s) {
        x0 *= s;
        x1 *= s;
        return this;
    }
}
