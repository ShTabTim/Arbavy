package com.sh_tab.arbavy.graphics;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class RendererGLES20 implements GLSurfaceView.Renderer {
    private int programId;
    public float g = 0.5f;
    public float n = 1;

    protected int width;
    protected int height;


    //private FloatBuffer vertexData;
    //private int unLocation;
    //private int aPositionLocation;
    //private String vert = "attribute vec4 a_Position;\n" +
    //        "\n" +
    //        "uniform float u_n;\n" +
    //        "void main()\n" +
    //        "{\n" +
    //        "    gl_Position = vec4(u_n*a_Position.x, u_n*a_Position.y, a_Position.z, a_Position.w);\n" +
    //        "}";
    //private String frag = "precision mediump float;\n" +
    //        "\n" +
    //        "void main()\n" +
    //        "{\n" +
    //        "    gl_FragColor = vec4(1.0, 1.0, 0.0, 0.0);\n" +
    //        "}";
    //public int createProgram(int vertexShaderId, int fragmentShaderId) {
//
    //    final int programId = GLES20.glCreateProgram();
    //    if (programId == 0) {
    //        return 0;
    //    }
//
    //    GLES20.glAttachShader(programId, vertexShaderId);
    //    GLES20.glAttachShader(programId, fragmentShaderId);
//
    //    GLES20.glLinkProgram(programId);
    //    final int[] linkStatus = new int[1];
    //    GLES20.glGetProgramiv(programId, GLES20.GL_LINK_STATUS, linkStatus, 0);
    //    if (linkStatus[0] == 0) {
    //        GLES20.glDeleteProgram(programId);
    //        return 0;
    //    }
    //    return programId;
//
    //}
    //public int createShader(int type, String shaderText) {
    //    final int shaderId = GLES20.glCreateShader(type);
    //    if (shaderId == 0) {
    //        return 0;
    //    }
    //    GLES20.glShaderSource(shaderId, shaderText);
    //    GLES20.glCompileShader(shaderId);
    //    final int[] compileStatus = new int[1];
    //    GLES20.glGetShaderiv(shaderId, GLES20.GL_COMPILE_STATUS, compileStatus, 0);
    //    if (compileStatus[0] == 0) {
    //        GLES20.glDeleteShader(shaderId);
    //        return 0;
    //    }
    //    return shaderId;
    //}
Image im;
    @Override
    public void onSurfaceCreated(GL10 arg0, EGLConfig arg1) {
        int[] dd = {
                0xFF00FFFF, 0xFFFF00FF, 0xFF00FFFF,
                0xFF00FFFF, 0xFFFF00FF, 0xFF00FFFF,
                0xFF00D0F0, 0xFFFF00FF, 0xFF00D0F0,
                };
        im = new Image(3, 3, dd);
        //prepareData();
        //int vertexShaderId = createShader(GLES20.GL_VERTEX_SHADER, vert);
        //int fragmentShaderId = createShader(GLES20.GL_FRAGMENT_SHADER, frag);
        //programId = createProgram(vertexShaderId, fragmentShaderId);
        //GLES20.glUseProgram(programId);
        //bindData();
    }

    //private void prepareData() {
    //    float[] vertices = {
    //            -0.5f, -0.2f,
    //            0.0f, 0.2f,
    //            0.5f, -0.2f,
    //    };
//
    //    vertexData = ByteBuffer
    //            .allocateDirect(vertices.length * 4)
    //            .order(ByteOrder.nativeOrder())
    //            .asFloatBuffer();
    //    vertexData.put(vertices);
    //}

    //private void bindData(){
    //    unLocation = GLES20.glGetUniformLocation(programId, "u_n");
    //    GLES20.glUniform1f(unLocation, n);
//
    //    aPositionLocation = GLES20.glGetAttribLocation(programId, "a_Position");
    //    vertexData.position(0);
    //    GLES20.glVertexAttribPointer(aPositionLocation, 2, GLES20.GL_FLOAT,
    //            false, 0, vertexData);
    //    GLES20.glEnableVertexAttribArray(aPositionLocation);
    //}
public float v = 1, dt = 0.001f, f = 0;
    @Override
    public void onDrawFrame(GL10 arg0) {
        GLES20.glScissor( 0, 0, width, height );
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
        GLES20.glClear(GLES20.GL_DEPTH_BUFFER_BIT);
        GLES20.glClearColor(0f, g, 0.5f, 0f);
        float[] mm = {
                (float)Math.cos(n),
                -(float)Math.sin(n),
                (float)Math.sin(n),
                (float)Math.cos(n),
        };
        im.draw(4, 4, mm);
        //GLES20.glUniform1f(unLocation, n);
        //GLES20.glDrawArrays(GLES20.GL_TRIANGLES, 0, 3);
        f = -10000*(n-0.1f)-50*v;
        n += v*dt + f*dt*dt*0.5f;
        if (n > 0.1f) {n = 0.1f; v = -v;}
        n = Math.min(0.1f, Math.max(-2.0f, n));
        v += f*dt;
    }

    @Override
    public void onSurfaceChanged(GL10 arg0, int width, int height) {
        GLES20.glViewport(0, 0, this.width = width, this.height = height);
    }
}
