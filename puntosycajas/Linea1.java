package com.example.puntosycajas;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

import android.graphics.Canvas.VertexMode;
public class Linea1{

private float vertices[] = new float [] {
-2,4, 
-1,4,

-1,4, 
-1,3,

-1,3, 
-2,3,

-2,3, 
-2,4,

-1,0, 
-1,-1,

-1,0, 
0,0,

2,1,
1,1

-2,-2,
-1,-2,


1,0,
1,-1,

};

FloatBuffer bufVertices;
public Linea1(){
ByteBuffer bufByte = ByteBuffer.allocateDirect(vertices.length * 4);
bufByte.order(ByteOrder.nativeOrder()); 
bufVertices = bufByte.asFloatBuffer(); 
bufVertices.put(vertices);
bufVertices.rewind(); 
}
public void dibuja(GL10 gl) {
	gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
	gl.glVertexPointer(2, GL10.GL_FLOAT, 0, bufVertices);
	gl.glColor4f(0, 0, 1, 0);
	gl.glDrawArrays(GL10.GL_LINE_STRIP, 0,8);
	
	gl.glColor4f(0, 0, 1, 0);
	gl.glDrawArrays(GL10.GL_LINE_STRIP, 8,4);
	

	
	
	gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
}
}