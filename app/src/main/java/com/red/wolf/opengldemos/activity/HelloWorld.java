package com.red.wolf.opengldemos.activity;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.red.wolf.opengldemos.opengl.IOpenGLDemo;
import com.red.wolf.opengldemos.opengl.OpenGlRenderer;

import javax.microedition.khronos.opengles.GL10;

/**
 *  HelloWorld
 */
public class HelloWorld extends Activity implements IOpenGLDemo {
    private GLSurfaceView glSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //  初始化GLSurfaceView
        glSurfaceView = new GLSurfaceView(this);
        //  给他设置一个渲染器
        glSurfaceView.setRenderer(new OpenGlRenderer(this));
        //  塞入视图
        setContentView(glSurfaceView);
    }

    @Override
    public void DrawScene(GL10 gl10) {
        //  绘制 给他一个颜色
        gl10.glClearColor(1.0f, 0.0f, 0.0f, 0.0f);
        //  清除深度缓冲区和颜色缓冲区
        gl10.glClear(GL10.GL_DEPTH_BUFFER_BIT | GL10.GL_COLOR_BUFFER_BIT);
    }

    //  实现onResume和onPause 目的是在程序失去焦点的时候 做相应的操作
    @Override
    protected void onResume() {
        super.onResume();
        glSurfaceView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        glSurfaceView.onPause();
    }
}
