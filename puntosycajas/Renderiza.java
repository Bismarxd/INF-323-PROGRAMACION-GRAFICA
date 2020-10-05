package com.example.puntosycajas;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;
import android.view.MotionEvent;


public class Renderiza extends GLSurfaceView implements Renderer {

private Linea linea;
private Linea linea1;
private Linea linea2;
private Linea linea3; 
private Linea linea4; 


private Linea1 linea5; 


private int alto;
private int ancho;

Context contexto;

private final int MAX_NUM_PUNTOS = 1;

private float puntos[][] = new float[MAX_NUM_PUNTOS][2];
private float puntos1[][] = new float[MAX_NUM_PUNTOS][2];
private float puntos2[][] = new float[MAX_NUM_PUNTOS][2];

private int numPuntos = 0;
private int numPuntos1 = 0;
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
linea = new Linea();
linea1 = new Linea();
linea2 = new Linea();
linea3 = new Linea();
linea4 = new Linea();


linea5 = new Linea1();


gl.glClearColor(1, 1, 1, 1);
}
@Override
public void onDrawFrame(GL10 gl) {

gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

gl.glLineWidth(5);
gl.glEnable (GL10.GL_LINE_SMOOTH);
gl.glPointSize(8);
gl.glEnable (GL10.GL_POINT_SMOOTH);

//linea 1
adicionaUnNuevoPunto(-2, 4);
linea.setVertices(numPuntos, puntos);
linea.dibuja(gl);

adicionaUnNuevoPunto(-1, 4);
linea1.setVertices(numPuntos, puntos);
linea1.dibuja(gl);

adicionaUnNuevoPunto(0, 4);
linea2.setVertices(numPuntos, puntos);
linea2.dibuja(gl);

adicionaUnNuevoPunto(1, 4);
linea3.setVertices(numPuntos, puntos);
linea3.dibuja(gl);

adicionaUnNuevoPunto(2, 4);
linea4.setVertices(numPuntos, puntos);
linea4.dibuja(gl);

//linea 2
adicionaUnNuevoPunto(-2, 3);
linea.setVertices(numPuntos, puntos);
linea.dibuja(gl);

adicionaUnNuevoPunto(-1, 3);
linea1.setVertices(numPuntos, puntos);
linea1.dibuja(gl);

adicionaUnNuevoPunto(0,3);
linea2.setVertices(numPuntos, puntos);
linea2.dibuja(gl);

adicionaUnNuevoPunto(1, 3);
linea3.setVertices(numPuntos, puntos);
linea3.dibuja(gl);

adicionaUnNuevoPunto(2, 3);
linea4.setVertices(numPuntos, puntos);
linea4.dibuja(gl);

//linea 3
adicionaUnNuevoPunto(-2, 2);
linea.setVertices(numPuntos, puntos);
linea.dibuja(gl);

adicionaUnNuevoPunto(-1, 2);
linea1.setVertices(numPuntos, puntos);
linea1.dibuja(gl);

adicionaUnNuevoPunto(0,2);
linea2.setVertices(numPuntos, puntos);
linea2.dibuja(gl);

adicionaUnNuevoPunto(1, 2);
linea3.setVertices(numPuntos, puntos);
linea3.dibuja(gl);

adicionaUnNuevoPunto(2, 2);
linea4.setVertices(numPuntos, puntos);
linea4.dibuja(gl);

//linea 4
adicionaUnNuevoPunto(-2, 1);
linea.setVertices(numPuntos, puntos);
linea.dibuja(gl);

adicionaUnNuevoPunto(-1, 1);
linea1.setVertices(numPuntos, puntos);
linea1.dibuja(gl);

adicionaUnNuevoPunto(0,1);
linea2.setVertices(numPuntos, puntos);
linea2.dibuja(gl);

adicionaUnNuevoPunto(1, 1);
linea3.setVertices(numPuntos, puntos);
linea3.dibuja(gl);

adicionaUnNuevoPunto(2, 1);
linea4.setVertices(numPuntos, puntos);
linea4.dibuja(gl);

//linea 5
adicionaUnNuevoPunto(-2, 0);
linea.setVertices(numPuntos, puntos);
linea.dibuja(gl);

adicionaUnNuevoPunto(-1, 0);
linea1.setVertices(numPuntos, puntos);
linea1.dibuja(gl);

adicionaUnNuevoPunto(0,0);
linea2.setVertices(numPuntos, puntos);
linea2.dibuja(gl);

adicionaUnNuevoPunto(1, 0);
linea3.setVertices(numPuntos, puntos);
linea3.dibuja(gl);

adicionaUnNuevoPunto(2, 0);
linea4.setVertices(numPuntos, puntos);
linea4.dibuja(gl);

//linea 6
adicionaUnNuevoPunto(-2, -1);
linea.setVertices(numPuntos, puntos);
linea.dibuja(gl);

adicionaUnNuevoPunto(-1, -1);
linea1.setVertices(numPuntos, puntos);
linea1.dibuja(gl);

adicionaUnNuevoPunto(0,-1);
linea2.setVertices(numPuntos, puntos);
linea2.dibuja(gl);

adicionaUnNuevoPunto(1, -1);
linea3.setVertices(numPuntos, puntos);
linea3.dibuja(gl);

adicionaUnNuevoPunto(2, -1);
linea4.setVertices(numPuntos, puntos);
linea4.dibuja(gl);


//linea 7
adicionaUnNuevoPunto(-2, -2);
linea.setVertices(numPuntos, puntos);
linea.dibuja(gl);

adicionaUnNuevoPunto(-1, -2);
linea1.setVertices(numPuntos, puntos);
linea1.dibuja(gl);

adicionaUnNuevoPunto(0,-2);
linea2.setVertices(numPuntos, puntos);
linea2.dibuja(gl);

adicionaUnNuevoPunto(1, -2);
linea3.setVertices(numPuntos, puntos);
linea3.dibuja(gl);

adicionaUnNuevoPunto(2, -2);
linea4.setVertices(numPuntos, puntos);
linea4.dibuja(gl);

//linea 8
adicionaUnNuevoPunto(-2, -3);
linea.setVertices(numPuntos, puntos);
linea.dibuja(gl);

adicionaUnNuevoPunto(-1, -3);
linea1.setVertices(numPuntos, puntos);
linea1.dibuja(gl);

adicionaUnNuevoPunto(0,-3);
linea2.setVertices(numPuntos, puntos);
linea2.dibuja(gl);

adicionaUnNuevoPunto(1, -3);
linea3.setVertices(numPuntos, puntos);
linea3.dibuja(gl);

adicionaUnNuevoPunto(2, -3);
linea4.setVertices(numPuntos, puntos);
linea4.dibuja(gl);

//linea 8
adicionaUnNuevoPunto(-2, -4);
linea.setVertices(numPuntos, puntos);
linea.dibuja(gl);

adicionaUnNuevoPunto(-1, -4);
linea1.setVertices(numPuntos, puntos);
linea1.dibuja(gl);

adicionaUnNuevoPunto(0,-4);
linea2.setVertices(numPuntos, puntos);
linea2.dibuja(gl);

adicionaUnNuevoPunto(1, -4);
linea3.setVertices(numPuntos, puntos);
linea3.dibuja(gl);

adicionaUnNuevoPunto(2, -4);
linea4.setVertices(numPuntos, puntos);
linea4.dibuja(gl);

//////////////////////////////////////*****************///////////////////

linea5.dibuja(gl);


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



@Override
public boolean onTouchEvent(MotionEvent e) {
/* Obtiene la coordenada de la pantalla */
float posx = e.getX();
float posy = e.getY();


/* Se considera cuando el dedo toca la pantalla. */
if (e.getAction() == MotionEvent.ACTION_DOWN) {
/* En coordenadas del OpenGL */
posx = ((posx / (float) ancho) * 8) - 4;
posy = ((1 - posy / (float) alto) * 12) - 6;

/* Adiciona un nuevo punto */

adicionaUnNuevoPunto(-2, -5);
adicionaUnNuevoPunto(-3, -5);


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
	if (numPuntos1 >= MAX_NUM_PUNTOS) {
		eliminaElPrimerPunto();
		}
			
		puntos1[numPuntos1][0] = x;
		puntos1[numPuntos1][1] = y;
		numPuntos1++;
}

public void adicionaUnNuevoPunto2(float x, float y) {
/*if (numPuntos >= MAX_NUM_PUNTOS) {
eliminaElPrimerPunto();
}*/
puntos1[numPuntos][0] = x;
puntos1[numPuntos][1] = y;
numPuntos1++;
}

}