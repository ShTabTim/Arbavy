package com.sh_tab.sh_j_engine.shmath;

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
    public vec2f minus(vec2f o) {
        x0 -= o.x0;
        x1 -= o.x1;
        return this;
    }
    public vec2f minus() {
        x0 = -x0;
        x1 = -x1;
        return this;
    }
    public<T> vec2f scl(T  s) {
        return scl((float)s);
    }
    public vec2f scl(float s) {
        x0 *= s;
        x1 *= s;
        return this;
    }

    public vec2f rotate(float a) {
        a*=2*Math.PI;
        float _x0 = x0, sin = (float) Math.sin(a), cos = (float) Math.cos(a);
        x0 =  _x0*cos + x1*sin;
        x1 = -_x0*sin + x1*cos;
        return this;
    }
}
