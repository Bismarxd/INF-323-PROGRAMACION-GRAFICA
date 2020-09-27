package com.example.opengl10_2d_conectandopuntos;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;
import android.view.MotionEvent;


public class Renderiza extends GLSurfaceView implements Renderer {

private Polilinea polilinea;
private Polilinea polilinea1;

private int alto;
private int ancho;

Context contexto;

private final int MAX_NUM_PUNTOS = 10;
private float puntos[][] = new float[MAX_NUM_PUNTOS][2];
private int numPuntos = 0;
public Renderiza(Context contexto) {
super(contexto);
this.contexto = contexto;

this.setRenderer(this);

this.requestFocus();

this.setFocusableInTouchMode(true);

this.setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
}


@Override
public void onSurfaceCreated(GL10 gl, EGLConfig arg1) {
polilinea = new Polilinea();
polilinea1 = new Polilinea();

gl.glClearColor(1, 1, 1, 1);
}
@Override
public void onDrawFrame(GL10 gl) {

gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

gl.glLineWidth(5);
gl.glEnable (GL10.GL_LINE_SMOOTH);
gl.glPointSize(8);
gl.glEnable (GL10.GL_POINT_SMOOTH);
polilinea.setVertices(numPuntos, puntos);
polilinea1.setVertices(numPuntos, puntos);
polilinea.dibuja(gl);
polilinea1.dibuja(gl);
}


@Override
public void onSurfaceChanged(GL10 gl, int w, int h) {
/* Obtiene el ancho y el alto de la pantalla */
ancho = w;
alto = h;
/* Ventana de despliegue */
gl.glViewport(0, 0, ancho, alto);
/* Matriz de Proyección */
gl.glMatrixMode(GL10.GL_PROJECTION);
/* Inicializa la Matriz de Proyección */
gl.glLoadIdentity();
/* Proyección paralela */
GLU.gluOrtho2D(gl, -4, 4, -6, 6);
/* Matriz del Modelo-Vista */
gl.glMatrixMode(GL10.GL_MODELVIEW);
/* Inicializa la Matriz del Modelo-Vista */
gl.glLoadIdentity();
}
/**
* Maneja los eventos de la pantalla táctil.
*/


@Override
public boolean onTouchEvent(MotionEvent e) {
/* Obtiene la coordenada de la pantalla */
float posx = e.getX();
float posy = e.getY();

float posa = e.getX();
float posb = e.getY();
/* Se considera cuando el dedo toca la pantalla. */
if (e.getAction() == MotionEvent.ACTION_DOWN) {
/* En coordenadas del OpenGL */
posx = ((posx / (float) ancho) * 8) - 4;
posy = ((1 - posy / (float) alto) * 12) - 6;

posa = ((posx / (float) ancho) * 6) - 4;
posb = ((1 - posy / (float) alto) * 8) - 6;
/* Adiciona un nuevo punto */
adicionaUnNuevoPunto(posx, posy);
adicionaUnNuevoPunto(posa, posb);
requestRender(); // Llama por defecto
}
return true;
}
/* Elimina el primer punto */
public void eliminaElPrimerPunto() {
	boolean s=true;

if (numPuntos > 0) {
numPuntos--;
for (int i = 0; i < numPuntos; i++) {
	if(s==true)
	{
		puntos[i][0] = puntos[numPuntos][0];
		puntos[i][1] = puntos[numPuntos][1];
		s=false;
	}
	else{
puntos[i][0] = puntos[i+1][0];
puntos[i][1] = puntos[i+1][1];
	}
}
}
}
/* Adiciona un nuevo punto */


public void adicionaUnNuevoPunto(float x, float y) {
if (numPuntos >= MAX_NUM_PUNTOS) {
eliminaElPrimerPunto();
}
puntos[numPuntos][0] = x;
puntos[numPuntos][1] = y;
numPuntos++;
}

public void adicionaUnNuevoPunto1(float x, float y) {

puntos[numPuntos][0] = x;
puntos[numPuntos][1] = y;
numPuntos++;
}
}