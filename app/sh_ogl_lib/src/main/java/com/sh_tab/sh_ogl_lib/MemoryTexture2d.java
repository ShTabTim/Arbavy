package com.sh_tab.sh_ogl_lib;

import android.opengl.GLES20;

public class MemoryTexture2d extends Texture2d {
    public int width;
    public int height;
    public int[] bufferARGB;

    boolean filtratedMin;
    boolean filtratedMax;

    public boolean clamped_not_repeated_x;
    public boolean clamped_not_repeated_y;

    public MemoryTexture2d(int width, int height, int[] bufferARGB) {
        this(width, height, bufferARGB, false, false, true, true);
    }

    public MemoryTexture2d(int width, int height, int[] bufferARGB, boolean filtratedMin, boolean filtratedMax, boolean clamped_not_repeated_x, boolean clamped_not_repeated_y) {
        super();
        this.width = width;
        this.height = height;
        this.bufferARGB = bufferARGB.clone();
        pixels(width, height, this.bufferARGB);
        filter(filtratedMin, filtratedMax);
        wrap(clamped_not_repeated_x, clamped_not_repeated_y);
    }

    public void wrap(boolean x, boolean y) {
        clamped_not_repeated_x = x;
        clamped_not_repeated_y = y;
        super.wrap(x?GLES20.GL_CLAMP_TO_EDGE:GLES20.GL_REPEAT, y?GLES20.GL_CLAMP_TO_EDGE:GLES20.GL_REPEAT);
    }

    public void filter(boolean min, boolean max) {
        filtratedMin = min;
        filtratedMax = max;
        super.filter(min?GLES20.GL_LINEAR:GLES20.GL_NEAREST, max?GLES20.GL_LINEAR:GLES20.GL_NEAREST);
    }
}
