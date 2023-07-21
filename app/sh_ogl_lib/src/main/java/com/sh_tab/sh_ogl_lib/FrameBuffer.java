package com.sh_tab.sh_ogl_lib;

import android.opengl.GLES20;

public class FrameBuffer {
    private final int id;

    public FrameBuffer() {
        int[] buffers = new int[1];
        GLES20.glGenBuffers(1, buffers, 0);
        id = buffers[0];
    }

    public void bind() {
        GLES20.glBindFramebuffer(GLES20.GL_FRAMEBUFFER, id);
    }

    public void delete() {
        int[] buffers = { id };
        GLES20.glDeleteFramebuffers(1, buffers, 0);
    }

    public void attach(int point, Texture2d tex) {
        bind();
        GLES20.glFramebufferTexture2D(GLES20.GL_FRAMEBUFFER, point, GLES20.GL_TEXTURE_2D, tex.getId(), 0 );
    }

    public void attach(int point, RenderBuffer buffer) {
        bind();
        GLES20.glFramebufferRenderbuffer(GLES20.GL_RENDERBUFFER, point, GLES20.GL_TEXTURE_2D, buffer.getId());
    }

    public boolean is_compile() {
        bind();
        return GLES20.glCheckFramebufferStatus(GLES20.GL_FRAMEBUFFER) == GLES20.GL_FRAMEBUFFER_COMPLETE;
    }
}
