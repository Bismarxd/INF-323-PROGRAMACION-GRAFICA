package com.example.a323_9_cubocolorinterracion;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.view.MotionEvent;
public class Renderiza extends GLSurfaceView implements Renderer {
    /* Objeto */
    private Cubo cubo;
    private Cubo2 cubo2;
    private Cubo3 cubo3;
    private Cubo4 cubo4;
    private Cubo5 cubo5;
    private Cubo6 cubo6;
    private Cubo7 cubo7;
    private Cubo8 cubo8;
    /* Para la rotación */
    private float trazoHorizontal;
    private float trazoVertical;
    private float antX;
    private float antY;
    public Renderiza(Context contexto) {
        super(contexto);
        /* Se inicia el renderizado */
        this.setRenderer(this);
        /* La ventana solicita recibir una entrada */
        this.requestFocus();

        /* Se establece que la ventana detecte el modo táctil */
        this.setFocusableInTouchMode(true);
        /* Se renderizará al inicio o cuando se llame a requestRender() */
        this.setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }
    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig arg1) {
        cubo = new Cubo();
        cubo2 = new Cubo2();
        cubo3 = new Cubo3();
        cubo4 = new Cubo4();
        cubo5 = new Cubo5();
        cubo6 = new Cubo6();
        cubo7 = new Cubo7();
        cubo8 = new Cubo8();
        /* Se habilita el modo de sombreado plano */
        gl.glShadeModel(GL10.GL_FLAT);
        /* Se habilita el ocultamiento de superficies */
        gl.glEnable(GL10.GL_DEPTH_TEST);
        /* Color de fondo */
        gl.glClearColor(0, 0, 0, 0);
    }
    @Override
    public void onDrawFrame(GL10 gl) {
        /* Se inicializa el buffer de color y de profundidad */
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        /* Se inicializa la Matriz del Modelo-Vista */
        gl.glLoadIdentity();
        /* Rota el cubo */
        gl.glRotatef(trazoHorizontal, 0.0f, 1.0f, 0.0f);
        gl.glRotatef(trazoVertical, 1.0f, 0.0f, 0.0f);
        cubo.dibuja(gl); // P' = Ry Rx P
//CUBO2
        gl.glRotatef(trazoHorizontal, 0.0f, 1.0f, 0.0f);
        gl.glRotatef(trazoVertical, 1.0f, 0.0f, 0.0f);
        cubo2.dibuja(gl);

        //CUBO3
        gl.glRotatef(trazoHorizontal, 0.0f, 1.0f, 0.0f);
        gl.glRotatef(trazoVertical, 1.0f, 0.0f, 0.0f);
        cubo3.dibuja(gl);

        //CUBO4
        gl.glRotatef(trazoHorizontal, 0.0f, 1.0f, 0.0f);
        gl.glRotatef(trazoVertical, 1.0f, 0.0f, 0.0f);
        cubo4.dibuja(gl);

        //CUBO5
        gl.glRotatef(trazoHorizontal, 0.0f, 1.0f, 0.0f);
        gl.glRotatef(trazoVertical, 1.0f, 0.0f, 0.0f);
        cubo5.dibuja(gl);

        //CUBO6
        gl.glRotatef(trazoHorizontal, 0.0f, 1.0f, 0.0f);
        gl.glRotatef(trazoVertical, 1.0f, 0.0f, 0.0f);
        cubo6.dibuja(gl);

        //CUBO7
        gl.glRotatef(trazoHorizontal, 0.0f, 1.0f, 0.0f);
        gl.glRotatef(trazoVertical, 1.0f, 0.0f, 0.0f);
        cubo7.dibuja(gl);

        //CUBO7
        gl.glRotatef(trazoHorizontal, 0.0f, 1.0f, 0.0f);
        gl.glRotatef(trazoVertical, 1.0f, 0.0f, 0.0f);
        cubo8.dibuja(gl);

        /* Se asegura que se ejecute las anteriores instrucciones */
        gl.glFlush();
    }
    @Override
    public void onSurfaceChanged(GL10 gl, int w, int h) {
        /* Ventana de despliegue */
        gl.glViewport(0, 0, w, h);
        /* Matriz de Proyección */
        gl.glMatrixMode(GL10.GL_PROJECTION);
        /* Se inicializa la Matriz de Proyección */
        gl.glLoadIdentity();
        /* Proyección paralela */
        if (w <= h)
            gl.glOrthof(-2, 2, -2 * (float) h / (float) w, 2 * (float) h
                    / (float) w, -10, 10);
        else
            gl.glOrthof(-2 * (float) w / (float) h, 2 * (float) w / (float) h,
                    -2, 2, -10, 10);
        /* Matriz del Modelo-Vista */
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        /* Se inicializa la Matriz del Modelo-Vista */
        gl.glLoadIdentity();
    }
    /**
     * Maneja los eventos del movimiento en la pantalla táctil.
     */
    @Override
    public boolean onTouchEvent(MotionEvent e) {
        float x = e.getX();
        float y = e.getY();
        switch (e.getAction()) {
            case MotionEvent.ACTION_MOVE:
                float dx = x - antX;
                float dy = y - antY;
                trazoHorizontal = trazoHorizontal + dx * 1.125f; // 360 / 320 = 1.125
                trazoVertical = trazoVertical + dy * 0.75f; // 360 / 480 = 0.75
                requestRender();
        }
        antX = x;
        antY = y;
        return true;
    }
}