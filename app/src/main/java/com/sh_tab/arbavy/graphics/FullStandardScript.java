package com.sh_tab.arbavy.graphics;

import android.opengl.GLES20;

import com.sh_tab.sh_ogl_lib.Attribute;
import com.sh_tab.sh_ogl_lib.Script;
import com.sh_tab.sh_ogl_lib.Uniform;

import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public class FullStandardScript extends Script {

    public Uniform uCamera;
    public Uniform uModel;
    public Uniform uTexture;
    public Attribute aPosition;
    public Attribute aUV;
    public Attribute aColorM;
    public Attribute aColorA;

    String vertexShader =
            "uniform mat4 uCamera;\n" +
            "uniform mat4 uModel;\n" +
            "attribute vec4 aPosition;\n" +
            "attribute vec4 aColorM;\n" +
            "attribute vec4 aColorA;\n" +
            "attribute vec2 aUV;\n" +
            "varying vec4 vColorM;\n" +
            "varying vec4 vColorA;\n" +
            "varying vec2 vUV;\n" +
            "\n" +
            "void main() {\n" +
            "   gl_Position = uCamera*uModel*aPosition;\n" +
            "   vUV = aUV;\n" +
            "   vColorM = aColorM;\n" +
            "   vColorA = aColorA;\n" +
            "}\n";

    String fragmentShader =
            "precision mediump float;\n" +
            "varying vec4 vColorM;\n" +
            "varying vec4 vColorA;\n" +
            "varying vec2 vUV;\n" +
            "uniform sampler2D uTexture;\n" +
            "\n" +
            "void main() {\n" +
            "   gl_FragColor = texture2D( uTex, vUV ) * vColorM + vColorA;\n" +
            "}\n";

    public FullStandardScript() {
        super();
        compile(vertexShader, fragmentShader);
        uCamera = uniform("uCamera");
        uModel = uniform("uModel");
        uTexture = uniform("uTexture");
        aColorM = attribute("aColorM");
        aColorA = attribute("aColorA");
        aPosition = attribute("aPosition");
        aUV = attribute("aUV");
    }

    @Override
    public void use() {
        super.use();
        aPosition.enable();
        aUV.enable();
        aColorM.enable();
        aColorA.enable();
    }

    private void setAttributes(FloatBuffer vertices) {
        vertices.position(0);
        aPosition.vertexPointer(3, 13, vertices);

        vertices.position(3);
        aUV.vertexPointer(2, 13, vertices);

        vertices.position(5);
        aColorM.vertexPointer(4, 13, vertices);

        vertices.position(9);
        aColorA.vertexPointer(4, 13, vertices);

        vertices.position(0);
    }

    public void drawElements(FloatBuffer vertices, ShortBuffer indices, int size) {
        setAttributes(vertices);
        GLES20.glDrawElements(GLES20.GL_TRIANGLES, size, GLES20.GL_UNSIGNED_SHORT, indices);
    }

    public void drawQuad( FloatBuffer vertices ) {
        setAttributes(vertices);
        GLES20.glDrawElements( GLES20.GL_TRIANGLES, Quad.amount, GLES20.GL_UNSIGNED_SHORT, Quad.getIndices( 1 ) );

    }

    public void drawQuadSet(FloatBuffer vertices, int size) {
        if (size == 0) {
            return;
        }
        setAttributes(vertices);
        GLES20.glDrawElements(GLES20.GL_TRIANGLES, Quad.amount * size, GLES20.GL_UNSIGNED_SHORT, Quad.getIndices(size));
    }

    public static FullStandardScript get() {
        return Script.use(FullStandardScript.class);
    }
}
