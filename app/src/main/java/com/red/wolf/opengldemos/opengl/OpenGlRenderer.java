package com.red.wolf.opengldemos.opengl;

import android.opengl.GLSurfaceView;
import android.opengl.GLU;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * 同一图形绘制
 */
public class OpenGlRenderer implements GLSurfaceView.Renderer {

    private final IOpenGLDemo openGLDemo;

    public OpenGlRenderer(IOpenGLDemo openGLDemo) {
        this.openGLDemo = openGLDemo;
    }

    /**
     * 仅调用一次,初始化参数 颜色,是否使用缓冲区等等
     *
     * @param gl10
     * @param eglConfig
     */
    @Override
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {
        //  设置背景色<RGBA>
        gl10.glClearColor(0.0f, 0.0f, 0.0f, 0.5f);
        //  启用平滑着色<默认不开启>
        gl10.glShadeModel(GL10.GL_SMOOTH);
        //  启用深度缓冲
        gl10.glClearDepthf(1.0f);
        //  启用深度缓冲测试
        gl10.glEnable(GL10.GL_DEPTH_TEST);
        //  设置深度测试的类型
        gl10.glDepthFunc(GL10.GL_LEQUAL);
        //  角度计算的方式
        gl10.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);


    }

    /**
     * 再屏幕方向切换的时候使用,可以用于重新设置纵横比率
     *
     * @param gl10
     * @param width
     * @param height
     */
    @Override
    public void onSurfaceChanged(GL10 gl10, int width, int height) {
        //  重设屏幕的宽高端口
        gl10.glViewport(0, 0, width, height);
        //  使用投影矩阵
        gl10.glMatrixMode(GL10.GL_PROJECTION);
        //  重新加载矩阵
        gl10.glLoadIdentity();
        //  计算窗口的纵横比
        GLU.gluPerspective(gl10, 45.0f, (float) width / (float) height, 0.1f, 100.0f);
        //  使用模型视图矩阵
        gl10.glMatrixMode(GL10.GL_MODELVIEW);
        //  重新加载<刚被设置的>矩阵
        gl10.glLoadIdentity();
    }

    /**
     * 渲染的核心方法,
     *
     * @param gl10
     */
    @Override
    public void onDrawFrame(GL10 gl10) {
        //  如果不为空 那么就绘制
        if (openGLDemo != null) {
            openGLDemo.DrawScene(gl10);
        }

    }
}
