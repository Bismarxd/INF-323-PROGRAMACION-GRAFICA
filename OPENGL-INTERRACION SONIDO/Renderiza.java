package com.opengl10_2d_interaccion_sonido;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;
import android.view.MotionEvent;
import android.widget.Toast;

public class Renderiza extends GLSurfaceView implements Renderer {

	private int alto;
	private int ancho;

	private Rectangulo rectangulo;
	private Rectangulo1 rectangulo1;
	private Circulo circulo;
	private Circulo1 circulo1;

	Context contexto;

	SonidoSoundPool sonido1;
	SonidoSoundPool sonido2;
	SonidoSoundPool sonido3;
	
	public Renderiza(Context contexto) {
		super(contexto);
		
		this.contexto = contexto;
		
		sonido1 = new SonidoSoundPool(contexto, "0437.ogg");
		sonido2 = new SonidoSoundPool(contexto, "0438.ogg");
		sonido3 = new SonidoSoundPool(contexto, "0564.ogg");

		this.setRenderer(this);

		this.requestFocus();

		this.setFocusableInTouchMode(true);

		this.setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
	}
	
	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig arg1) {
		
		rectangulo = new Rectangulo();
		rectangulo1 = new Rectangulo1();
		circulo = new Circulo(0.5f, 360, true);
		circulo1 = new Circulo1(0.5f, 360, true);
	
		/* Color de fondo */
		gl.glClearColor(0, 0, 0, 0);
	}
	
	
	//VERDE
	@Override
	public void onDrawFrame(GL10 gl) {

		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		gl.glLoadIdentity();
		
		rectangulo.dibuja(gl);

		gl.glTranslatef(0, -3, 0);
		
		circulo.dibuja(gl);

		gl.glTranslatef(0, -2, 0);
		
		circulo1.dibuja(gl);


	}

	
	@Override
	public void onSurfaceChanged(GL10 gl, int w, int h) {
		ancho = w;
		alto = h;

		gl.glViewport(0, 0, ancho, alto);

		gl.glMatrixMode(GL10.GL_PROJECTION);

		gl.glLoadIdentity();

		GLU.gluOrtho2D(gl, -4, 4, -6, 6);

		gl.glMatrixMode(GL10.GL_MODELVIEW);

		gl.glLoadIdentity();
		
		
		
	
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent e) {

		float posx = e.getX();
		float posy = e.getY();

		if (e.getAction() == MotionEvent.ACTION_UP) {

			posx = ((posx / (float) ancho) * 8) - 4;
			posy = ((1 - posy / (float) alto) * 12) - 6;

			if (puntoEstaDentroDelRectangulo(posx, posy, -3, 0, 3, 3)) {

				sonido1.play();

				Toast.makeText(contexto.getApplicationContext(), "Rojo",
						Toast.LENGTH_SHORT).show();

			} else if (puntoEstaDentroDelRectangulo(posx, posy, 0, 0, 3, 3)) {

				sonido2.play();

				Toast.makeText(contexto.getApplicationContext(), "Azul",
						Toast.LENGTH_SHORT).show();
			} else if (puntoEstaDentroDelRectangulo(posx, posy, -1, 1, 4, 6)) {
				
				sonido2.play();

				Toast.makeText(contexto.getApplicationContext(), "Verde",
						Toast.LENGTH_SHORT).show();
			
			} else if (puntoEstaDentroDelCirculo(posx, posy, 0, -3, 0.5f)) {

				sonido3.play();

				Toast.makeText(contexto.getApplicationContext(), "Amarillo",
						Toast.LENGTH_SHORT).show();

				
			}else if (puntoEstaDentroDelCirculo(posx, posy, 0, -5, 0.5f)) {

				sonido3.play();

				Toast.makeText(contexto.getApplicationContext(), "Escarlata",
						Toast.LENGTH_SHORT).show();

		}
		}
		return true;
	}
	
	private boolean puntoEstaDentroDelRectangulo(float posx, float posy, int x,
			int y, int ancho, int alto) {
		return (x < posx && posx < x + ancho && y < posy && posy < y + alto);
	}

	private boolean puntoEstaDentroDelCirculo(float posx, float posy, float x,
			float y, float radio) {
		return (distancia2(posx, posy, x, y) < radio * radio);
	}

	public float distancia2(float x1, float y1, float x2, float y2) {
		return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
	}
}
