package com.sh_tab.sh_ogl_lib;


import android.opengl.GLES20;

public class Program {
    private final int id;

    public Program() {
          id = GLES20.glCreateProgram();
    }
    public Program(Shader ... shaders) {
        this();
        create(shaders);
    }

    public int getId() {
        return id;
    }
    public void attachShader(Shader shad) {
        GLES20.glAttachShader(id, shad.getId());
    }

    public void link() {
        GLES20.glLinkProgram(id);

        int[] status = new int[1];
        GLES20.glGetProgramiv(id, GLES20.GL_LINK_STATUS, status, 0 );
        if (status[0] == GLES20.GL_FALSE) {
            throw new Error(GLES20.glGetProgramInfoLog(id));
        }
    }

    public void create(Shader ... shaders) {
        for (Shader shader : shaders) {
            attachShader(shader);
        }
        link();
    }

    public Attribute attribute(String name) {
        return new Attribute(GLES20.glGetAttribLocation(id, name));
    }

    public Uniform uniform(String name) {
        return new Uniform(GLES20.glGetUniformLocation(id, name));
    }

    public void use() {
        GLES20.glUseProgram(id);
    }

    public void delete() {
        GLES20.glDeleteProgram(id);
    }
}
