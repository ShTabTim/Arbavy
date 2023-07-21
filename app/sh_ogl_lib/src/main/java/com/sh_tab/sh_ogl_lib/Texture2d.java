package com.sh_tab.sh_ogl_lib;

import android.opengl.GLES20;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

public class Texture2d {
    protected final int id;

    public Texture2d() {
        int[] ids = new int[1];
        GLES20.glGenTextures(1, ids, 0);
        id = ids[0];
        bind();
    }

    public Texture2d(int width, int height, int[] pixels) {
        this();
        pixels(width, height, pixels);
    }

    public Texture2d(int width, int height, byte[] pixels) {
        this();
        pixels(width, height, pixels);
    }

    public int getId() {
        return id;
    }

    public static void activate(int id) {
        GLES20.glActiveTexture(GLES20.GL_TEXTURE0 + id);
    }

    public void bind() {
        GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, id);
    }

    public void filter(int minMode, int maxMode) {
        bind();
        GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MIN_FILTER, minMode);
        GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MAG_FILTER, maxMode);
    }

    public void wrap(int s, int t) {
        bind();
        GLES20.glTexParameterf( GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_S, s);
        GLES20.glTexParameterf( GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_T, t);
    }

    public void delete() {
        int[] ids = { id };
        GLES20.glDeleteTextures(1, ids, 0);
    }

    public void pixels( int w, int h, int[] pixels ) {
        bind();
        IntBuffer imageBuffer = ByteBuffer.allocateDirect(w*h*4).order(ByteOrder.nativeOrder()).asIntBuffer();
        imageBuffer.put(pixels);
        imageBuffer.position(0);
        GLES20.glTexImage2D(GLES20.GL_TEXTURE_2D, 0, GLES20.GL_RGBA, w, h, 0, GLES20.GL_RGBA, GLES20.GL_UNSIGNED_BYTE, imageBuffer);
    }

    public void pixels( int w, int h, byte[] pixels ) {
        bind();
        ByteBuffer imageBuffer = ByteBuffer.allocateDirect( w * h ).order(ByteOrder.nativeOrder());
        imageBuffer.put(pixels);
        imageBuffer.position(0);
        GLES20.glPixelStorei(GLES20.GL_UNPACK_ALIGNMENT, 1);
        GLES20.glTexImage2D(GLES20.GL_TEXTURE_2D, 0, GLES20.GL_ALPHA, w, h, 0, GLES20.GL_ALPHA, GLES20.GL_UNSIGNED_BYTE, imageBuffer);
    }
}
