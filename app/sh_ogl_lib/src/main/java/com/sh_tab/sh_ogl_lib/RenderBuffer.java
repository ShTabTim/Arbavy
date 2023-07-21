package com.sh_tab.sh_ogl_lib;

import android.opengl.GLES20;

public class RenderBuffer {
    private final int id;

    public RenderBuffer() {
        int[] buffers = new int[1];
        GLES20.glGenRenderbuffers(1, buffers, 0);
        id = buffers[0];
    }

    public int getId() {
        return id;
    }

    public void bind() {
        GLES20.glBindRenderbuffer(GLES20.GL_RENDERBUFFER, id);
    }

    public void storage(int format, int width, int height) {
        GLES20.glRenderbufferStorage(GLES20.GL_RENDERBUFFER, format , width, height);
    }

    public void delete() {
        int[] buffers = {id};
        GLES20.glDeleteRenderbuffers(1, buffers, 0);
    }
}
