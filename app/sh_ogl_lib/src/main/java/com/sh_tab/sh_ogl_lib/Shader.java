package com.sh_tab.sh_ogl_lib;

import android.opengl.GLES20;

public class Shader {
    private final int id;

    public Shader(int type) {
        id = GLES20.glCreateShader(type);
    }

    public Shader(int type, String src) {
        this(type);
        source(src);
        compile();
    }

    public int getId() {
        return id;
    }

    public void source(String src) {
        GLES20.glShaderSource(id, src);
    }

    public void compile() {
        GLES20.glCompileShader(id);

        int[] status = new int[1];
        GLES20.glGetShaderiv(id, GLES20.GL_COMPILE_STATUS, status, 0 );
        if (status[0] == GLES20.GL_FALSE) {
            throw new Error(GLES20.glGetShaderInfoLog(id));
        }
    }

    public void delete() {
        GLES20.glDeleteShader(id);
    }
}
