package com.example.pacman;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.opengles.GL10;

public class Linea {
FloatBuffer bufVertices;
int numPuntos;

FloatBuffer bufVertices1;
int numPuntos1;

public void setVertices(int numPuntos, float puntos[][]){
this.numPuntos = numPuntos;

ByteBuffer bufByte = ByteBuffer.allocateDirect(numPuntos * 2 * 4);
bufByte.order(ByteOrder.nativeOrder());
bufVertices = bufByte.asFloatBuffer();
for (int i = 0; i < numPuntos; i++) {
bufVertices.put(puntos[i][0]);
bufVertices.put(puntos[i][1]);
}
bufVertices.rewind(); 
}




public void dibuja(GL10 gl) {

gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);

gl.glVertexPointer(2, GL10.GL_FLOAT, 0, bufVertices);

gl.glColor4f(1.0f, 0f, 1f, 0);

if (numPuntos > 1)
gl.glDrawArrays(GL10.GL_LINE_STRIP, 0, numPuntos);

gl.glColor4f(0, 0, 1, 0);

gl.glDrawArrays(GL10.GL_POINTS, 0, numPuntos);

gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
}
}