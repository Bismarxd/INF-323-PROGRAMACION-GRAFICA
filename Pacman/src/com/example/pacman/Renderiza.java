package com.example.pacman;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;




import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;
import android.view.MotionEvent;


public class Renderiza extends GLSurfaceView implements Renderer {

	private CirculoGrafico c1_g, c2_g, c3_g;
	private Circulo c1, c2, c3;



private Linea1 linea; 


private float x_c1 = -2, y_c1 =  (float) 3.25;
private float x_c2 =  2, y_c2 =  3;
private float x_c3 = -5, y_c3 =  -2.5f;

private float x_r1 = -2, y_r1 = 0;
private float x_r2 =  2, y_r2 = 0;
private float x_r3 =  5, y_r3 = -3;

private float xVelocidad_c1 =   0.3f, yVelocidad_c1 = 0;
private float xVelocidad_c2 =  -0.1f, yVelocidad_c2 = 0;
private float xVelocidad_c3 =  0.03f, yVelocidad_c3 = 0;

private float xVelocidad_r1 =  0.05f, yVelocidad_r1 = 0;
private float xVelocidad_r2 = -0.05f, yVelocidad_r2 = 0;
private float xVelocidad_r3 = -0.03f, yVelocidad_r3 = 0;


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



linea = new Linea1();


gl.glClearColor(0, 0, 0, 1);

c1_g = new CirculoGrafico(0.18f, 270, true);
c1 = new Circulo(0, 0, 0.2f);
c2_g = new CirculoGrafico(0.2f, 360, true);
c2 = new Circulo(0, 0, 0.2f);
c3_g = new CirculoGrafico(0.2f, 360, true);
c3 = new Circulo(0, 0, 0.2f);
}
@Override
public void onDrawFrame(GL10 gl) {

gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

gl.glLineWidth(5);
gl.glEnable (GL10.GL_LINE_SMOOTH);
gl.glPointSize(8);
gl.glEnable (GL10.GL_POINT_SMOOTH);


gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

/* Colisión de dos circulos */
dibujaCirculo1(gl);
//dibujaCirculo2(gl);


x_c1 = x_c1 + xVelocidad_c1;
//if (x_c1 < -3.5f || x_c1 > 3.5f) // izq y der
	xVelocidad_c1 = -xVelocidad_c1;




//////////////////////////////////////*****************///////////////////

linea.dibuja(gl);


}

public void dibujaCirculo1(GL10 gl){
	gl.glPushMatrix();
	gl.glTranslatef(x_c1, y_c1, 0);
	c1.x = x_c1;
	c1.y = y_c1;
	gl.glColor4f(1, 1, 0, 1);
	c1_g.dibuja(gl);
	gl.glPopMatrix();
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