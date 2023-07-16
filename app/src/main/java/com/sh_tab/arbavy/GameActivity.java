package com.sh_tab.arbavy;

import android.app.Activity;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;

import com.sh_tab.sh_j_engine.gameObjects.Scene;

import java.util.ArrayList;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class GameActivity extends Activity implements GLSurfaceView.Renderer, View.OnTouchListener {
    protected int width;
    protected int height;

    protected Class<? extends Scene> mainScene;

    protected float timeSpeed = 1;
    private float delta_time = 0;
    private long time_alive = 0;

    protected GLSurfaceView surfView;
    protected SurfaceHolder surfHolder;

    protected ArrayList<MotionEvent> motionEvents = new ArrayList<MotionEvent>();

    protected ArrayList<KeyEvent> keyEvents = new ArrayList<KeyEvent>();
    public GameActivity(Class<? extends Scene> mainScene) {
        super();
        this.mainScene = mainScene;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {

    }

    @Override
    public void onSurfaceChanged(GL10 gl10, int w, int h) {
        GLES20.glViewport(0, 0, w, h);
        width = w;
        height = h;
    }

    @Override
    public void onDrawFrame(GL10 gl10) {
        if(width == 0 || height == 0) {
            return;
        }

        long time_now = System.currentTimeMillis();
        delta_time = timeSpeed*0.001f*((time_alive == 0) ? 0 : (time_now - time_alive));
        time_alive = time_now;

        GLES20.glScissor( 0, 0, width, height );
        GLES20.glClear( GLES20.GL_COLOR_BUFFER_BIT );

        draw();
    }

    protected void draw() {

    }

    protected void update(float dt) {

    }
}
