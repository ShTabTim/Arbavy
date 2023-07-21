package com.sh_tab.arbavy.graphics;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public class Quad {
    // 0---1
    // | \ |
    // 3---2
    public static final short[] vertexes = {0, 1, 2, 0, 2, 3};
    public static final int amount = vertexes.length;

    private static ShortBuffer indices;
    private static int indexSize = 0;

    public static FloatBuffer create() {
        return ByteBuffer.allocateDirect(2*Float.SIZE).order(ByteOrder.nativeOrder()).asFloatBuffer();
    }

    public static FloatBuffer createSet(int size) {
        return ByteBuffer.allocateDirect( size*2*Float.SIZE).order( ByteOrder.nativeOrder()).asFloatBuffer();
    }

    public static ShortBuffer getIndices(int size) {
        if (size > indexSize) {
            indexSize = size;
            indices = ByteBuffer.allocateDirect(size*amount*Short.SIZE/8).order(ByteOrder.nativeOrder() ).asShortBuffer();

            short[] values = new short[size*6];
            int pos = 0;
            int limit = size * 4;
            for (int ofs=0; ofs < limit; ofs += 4) {
                values[pos++] = (short)(ofs + vertexes[0]);
                values[pos++] = (short)(ofs + vertexes[1]);
                values[pos++] = (short)(ofs + vertexes[2]);
                values[pos++] = (short)(ofs + vertexes[3]);
                values[pos++] = (short)(ofs + vertexes[4]);
                values[pos++] = (short)(ofs + vertexes[5]);
            }

            indices.put(values);
            indices.position(0);
        }

        return indices;
    }

    public static void fill(float[] v, float x0, float x1, float y0, float y1, float u0, float u1, float v0, float v1) {
        fillXY(v, x0, x1, y0, y1);
        fillUV(v, u0, u1, v0, v1);
    }

    public static void fillXY(float[] v, float x0, float x1, float y0, float y1) {
        v[0] = x0; v[1] = y0;
        v[4] = x1; v[5] = y0;
        v[8] = x1; v[9] = y1;
        v[12]= x0; v[13]= y1;
    }

    public static void fillUV(float[] v, float u0, float u1, float v0, float v1) {
        v[2] = u0; v[3] = v0;
        v[6] = u1; v[7] = v0;
        v[10]= u1; v[11]= v1;
        v[14]= u0; v[15]= v1;
    }
}
