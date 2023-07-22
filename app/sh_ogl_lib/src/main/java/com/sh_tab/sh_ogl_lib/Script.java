package com.sh_tab.sh_ogl_lib;

import android.opengl.GLES20;

import java.util.HashMap;

public class Script extends Program {
    private static final HashMap<Class<? extends Script>,Script> all = new HashMap<Class<? extends Script>, Script>();
    private static Script currentScript = null;
    private static Class<? extends Script> currentScriptClass = null;

    @SuppressWarnings("unchecked")
    public static<T extends Script> T use( Class<T> c ) {
        if (c != currentScriptClass) {
            Script script = all.get(c);
            if (script == null) {
                try {
                    script = c.newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                all.put(c, script);
            }
            if (currentScript != null) {
                currentScript.unuse();
            }
            currentScript = script;
            currentScriptClass = c;
            currentScript.use();
        }
        return (T)currentScript;
    }

    public static void reset() {
        for (Script script : all.values()) {
            script.delete();
        }
        all.clear();
        currentScript = null;
        currentScriptClass = null;
    }

    public void compile(String vert, String frag) {
        super.create(new Shader(GLES20.GL_VERTEX_SHADER, vert), new Shader(GLES20.GL_FRAGMENT_SHADER, frag));
    }

    public void unuse() {}
}
