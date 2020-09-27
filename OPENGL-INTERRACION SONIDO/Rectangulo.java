package com.opengl10_2d_interaccion_sonido;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import javax.microedition.khronos.opengles.GL10;

public class Rectangulo {

	private float vertices[] = new float[] {

		-3, 0, // 0
		 0, 0, // 1
		 0, 3, // 2
		-3, 3, // 3

		 0, 0, // 4
		 3, 0, // 5
		 3, 3, // 6
		 0, 3,  // 7
		 
		
		-1, 4, // 8
		 1, 4, // 9
		 1, 6, //10
		 -1, 6  // 11
	};

	private byte colores[] = new byte[] {
	
		(byte)255, 0, 0, 0, // 0
		(byte)255, 0, 0, 0, // 1
		(byte)255, 0, 0, 0, // 2
		(byte)255, 0, 0, 0, // 3

		0, 0, (byte)255, 0, // 4
		0, 0, (byte)255, 0, // 5
		0, 0, (byte)255, 0, // 6
		0, 0, (byte)255, 0,  // 7
		

		0, (byte)255, 0, 0, // 8
		0, (byte)255, 0, 0, // 9
		0, (byte)255,0, 0, // 10
		0, (byte)255, 0, 0  // 11
	};
	
	private short indices[] = new short [] { 
		 0, 1, 2, 0, 2, 3, // Rectángulo 1
		 4, 5, 6, 4, 6, 7,  // Rectángulo 2
		 8, 9, 10, 8, 10, 11  // Rectángulo 3
	};
	
	FloatBuffer bufVertices;
	ByteBuffer bufColores;
	ShortBuffer bufIndices;
	
	public Rectangulo(){

		ByteBuffer bufByte = ByteBuffer.allocateDirect(vertices.length * 4);
		bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte nativo
		bufVertices = bufByte.asFloatBuffer(); // Convierte de byte a float
		bufVertices.put(vertices);
		bufVertices.rewind(); // puntero al principio del buffer

		bufColores = ByteBuffer.allocateDirect(colores.length);
		bufColores.put(colores);
		bufColores.rewind(); 


		bufByte = ByteBuffer.allocateDirect(indices.length * 2);
		bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte nativo
		bufIndices = bufByte.asShortBuffer(); // Convierte de byte a short
		bufIndices.put(indices);
		bufIndices.rewind();
		
	}
	
	public void dibuja(GL10 gl) {

		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);

		gl.glEnableClientState(GL10.GL_COLOR_ARRAY);

		gl.glVertexPointer(2, GL10.GL_FLOAT, 0, bufVertices);

		gl.glColorPointer(4, GL10.GL_UNSIGNED_BYTE, 0, bufColores);

		gl.glDrawElements(GL10.GL_TRIANGLES, indices.length,
				GL10.GL_UNSIGNED_SHORT, bufIndices);

		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

		gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
		
	}
}
