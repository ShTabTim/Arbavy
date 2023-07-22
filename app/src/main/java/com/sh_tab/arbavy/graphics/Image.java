package com.sh_tab.arbavy.graphics;

import com.sh_tab.sh_j_engine.shmath.mat2f;
import com.sh_tab.sh_ogl_lib.MemoryTexture2d;

import java.nio.FloatBuffer;

public class Image {
    //52//4*(3+2+4+4)
    protected float[] vertices;
    protected FloatBuffer verticesBuffer;
    public MemoryTexture2d texture;
    protected boolean dirty;

    public Image(int width, int height, int[] data) {
        texture = new MemoryTexture2d(width, height, data);
        vertices = new float[4*13];
        verticesBuffer = Quad.create();
        int p = 0;
        vertices[p + 0]  = 0;       vertices[p + 1]  = 0;       vertices[p + 2]  = 0;
        vertices[p + 3]  = 0;       vertices[p + 4]  = 0;
        vertices[p + 5]  = 1;       vertices[p + 6]  = 1;       vertices[p + 7]  = 1;       vertices[p + 8]  = 1;
        vertices[p + 9]  = 0;       vertices[p + 10] = 0;       vertices[p + 11] = 0;       vertices[p + 12] = 0;
        p += 13;
        vertices[p + 0]  = width;   vertices[p + 1]  = 0;     vertices[p + 2]  = 0;
        vertices[p + 3]  = 1;       vertices[p + 4]  = 0;
        vertices[p + 5]  = 1;       vertices[p + 6]  = 1;       vertices[p + 7]  = 1;       vertices[p + 8]  = 1;
        vertices[p + 9]  = 0;       vertices[p + 10] = 0;       vertices[p + 11] = 0;       vertices[p + 12] = 0;
        p += 13;
        vertices[p + 0]  = 0; vertices[p + 1]  = height; vertices[p + 2]  = 0;
        vertices[p + 3]  = 0; vertices[p + 4]  = 1;
        vertices[p + 5]  = 1;       vertices[p + 6]  = 1;       vertices[p + 7]  = 1;       vertices[p + 8]  = 1;
        vertices[p + 9]  = 0;       vertices[p + 10] = 0;       vertices[p + 11] = 0;       vertices[p + 12] = 0;
        p += 13;
        vertices[p + 0]  = width; vertices[p + 1]  = height; vertices[p + 2]  = 0;
        vertices[p + 3]  = 1; vertices[p + 4]  = 1;
        vertices[p + 5]  = 1;       vertices[p + 6]  = 1;       vertices[p + 7]  = 1;       vertices[p + 8]  = 1;
        vertices[p + 9]  = 0;       vertices[p + 10] = 0;       vertices[p + 11] = 0;       vertices[p + 12] = 0;
        dirty = true;
    }

    public void draw(int w, int h, float[] cam) {
        FullStandardScript script = FullStandardScript.get();
        texture.bind();
        float[] g = {1, 0, 0, 1};
        script.uInvCamera.valueM2(cam);
        script.uCamPos.value2f(0, 0);
        script.uCamSiz.value2f(w, h);
        script.uModel.valueM2(g);
        if(dirty) {
            verticesBuffer.position(0);
            verticesBuffer.put(vertices);
            dirty = false;
        }
        script.drawQuad(verticesBuffer);
    }
}
