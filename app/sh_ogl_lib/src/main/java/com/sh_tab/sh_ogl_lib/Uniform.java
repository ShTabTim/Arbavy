package com.sh_tab.sh_ogl_lib;

import android.opengl.GLES20;

public class Uniform {
    private final int location;

    public Uniform(int location) {
        this.location = location;
    }

    public int getLocation() {
        return location;
    }

    public void enable() {
        GLES20.glEnableVertexAttribArray(location);
    }

    public void disable() {
        GLES20.glDisableVertexAttribArray(location);
    }

    public void value1i(int v0) {
        GLES20.glUniform1i(location, v0);
    }

    public void value2i(int v0, int v1) {
        GLES20.glUniform2i(location, v0, v1);
    }

    public void value3i(int v0, int v1, int v2) {
        GLES20.glUniform3i(location, v0, v1, v2);
    }

    public void value4i(int v0, int v1, int v2, int v3) {
        GLES20.glUniform4i(location, v0, v1, v2, v3);
    }

    public void value1f(float v0) {
        GLES20.glUniform1f(location, v0);
    }

    public void value2f(float v0, float v1) {
        GLES20.glUniform2f(location, v0, v1);
    }

    public void value3f(float v0, float v1, float v2) {
        GLES20.glUniform3f(location, v0, v1, v2);
    }

    public void value4f(float v0, float v1, float v2, float v3) {
        GLES20.glUniform4f(location, v0, v1, v2, v3);
    }

    public void valueM2(float[] value) {
        GLES20.glUniformMatrix2fv(location, 1, false, value, 0);
    }

    public void valueM3(float[] value) {
        GLES20.glUniformMatrix3fv(location, 1, false, value, 0);
    }

    public void valueM4( float[] value ) {
        GLES20.glUniformMatrix4fv(location, 1, false, value, 0);
    }
}
