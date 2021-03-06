package com.opengl10_2d_interaccion_sonido;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.opengles.GL10;

public class Circulo {
	

	
	private FloatBuffer bufVertices;

	private int segmentos;
	private boolean llenado;

	public Circulo(float radio, int segmentos, boolean llenado) {
		this.segmentos = segmentos;
		this.llenado = llenado;
		

		ByteBuffer bufByte = ByteBuffer.allocateDirect(360 * 2 * 4);
		bufByte.order(ByteOrder.nativeOrder()); 
		bufVertices = bufByte.asFloatBuffer(); 
		
	
		int j = 0;
	 	for (float i = 0; i < 360.0f; i = i + 360.0f/segmentos) {
	 		bufVertices.put(j++, (float) Math.cos(Math.toRadians(i)) * radio);
	 		bufVertices.put(j++, (float) Math.sin(Math.toRadians(i)) * radio);
	 	}
	 	bufVertices.rewind();
		
	}
	
	public void dibuja(GL10 gl) {
		

		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		

		gl.glVertexPointer(2, GL10.GL_FLOAT, 0, bufVertices);
		

		gl.glColor4f(1, 1, 0, 0);

	
		gl.glDrawArrays((llenado) ? GL10.GL_TRIANGLE_FAN : GL10.GL_LINE_LOOP, 0, segmentos);
		
	
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		
	}
}
