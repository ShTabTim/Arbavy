package com.sh_tab.sh_j_engine.shmath;

public class mat2f {
    public float x00, x01;
    public float x10, x11;

    public mat2f(float x) {
        this(x, x);
    }

    public mat2f(float x00, float x11) {
        this(x00, 0, 0, x11);
    }

    public mat2f(float x00, float x01, float x10, float x11) {
        this.x00 = x00; this.x01 = x01;
        this.x10 = x10; this.x11 = x11;
    }

    public mat2f() {
        this(1);
    }

    public mat2f cpy() {
        return new mat2f(x00, x01, x10, x11);
    }

    public mat2f transpose() {
        return new mat2f(x00, x10, x01, x11);
    }

    public mat2f add(mat2f o) {
        x00 += o.x00; x01 += o.x01;
        x10 += o.x10; x11 += o.x11;
        return this;
    }

    public mat2f minus(mat2f o) {
        x00 -= o.x00; x01 -= o.x01;
        x10 -= o.x10; x11 -= o.x11;
        return this;
    }

    public<T> mat2f scl(T s) {
        return scl((float) s);
    }

    public mat2f scl(float s) {
        x00 *= s; x01 *= s;
        x10 *= s; x11 *= s;
        return this;
    }

    public static mat2f rotate(float a) {
        a*=2*Math.PI;
        float sin = (float) Math.sin(a), cos = (float) Math.cos(a);
        return new mat2f(cos, sin, -sin, cos);
    }
}
