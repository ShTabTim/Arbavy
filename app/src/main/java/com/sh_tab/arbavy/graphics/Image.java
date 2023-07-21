package com.sh_tab.arbavy.graphics;

import com.sh_tab.sh_ogl_lib.MemoryTexture2d;

import java.nio.FloatBuffer;

public class Image {
    //52//4*(3+2+4+4)
    protected float[] vertices;
    protected FloatBuffer verticesBuffer;
    public MemoryTexture2d texture;

    public void draw() {
        FullStandardScript script = FullStandardScript.get();
        texture.bind();

    }
}
