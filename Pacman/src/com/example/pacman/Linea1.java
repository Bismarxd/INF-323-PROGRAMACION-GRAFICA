package com.example.pacman;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

import android.graphics.Canvas.VertexMode;
public class Linea1{

private float vertices[] = new float [] {
 //1
		(float)-3.5,(float) -0.5,
		(float)-2.5,(float) -0.5,
		
		(float)-2.5,(float) -0.5,
		(float)-2.5,-3,
		
		(float)-2.5,-3,
		(float)-3.5,-3,
		
		(float)-3.5,-3,
		(float)-3.5,(float) -0.5,
		
//2
	//////
		0,(float) -2.5,
		(float)1.5,(float) -2.5,
		
		(float)1.5,(float) -2.5,
		(float)1.5,-3,
		
		(float)1.5,-3,
		-2,-3,
		
		-2,-3,
		(float)-2,(float) -2.5,
		/////
		(float)-2,(float) -2.5,
		(float)-0.5,(float) -2.5,
		
		(float)-0.5,(float) -2.5,
		(float)-0.5, -1,
		
		(float)-0.5, -1,
		0,-1,
		
		0,-1,
		0,(float) -2.5,
		
		//3
				(float)-3.5,(float) -5.5,
				(float)-3.5,(float) -3.5,
				
				(float)-3.5,(float) -3.5,
				(float)-2.5,(float) -3.5,
				
				(float)-2.5,(float) -3.5,
				(float)-2.5,(float) -5.5,
				
				(float)-2.5,(float) -5.5,
				(float)-3.5,(float) -5.5,
				
				//4
				(float)-2,(float) -5.5,
				-2,(float) -3.5,
				
				-2,(float) -3.5,
				(float) -1.5,(float) -3.5,
				
				(float) -1.5,(float) -3.5,
				(float)-1.5,(float) -5.5,
				
				(float)-1.5,(float) -5.5,
				(float)-2,(float) -5.5,
				
				//5
				(float)2,(float) -5.5,
				2,(float) -3.5,
				
				2,(float) -3.5,
				(float) 2.5,(float) -3.5,
				
				(float) 2.5,(float) -3.5,
				(float)2.5,(float) -5.5,
				
				(float)2.5,(float) -5.5,
				(float)2,(float) -5.5,
				
				//6
				(float)3,(float) -5.5,
				3,(float) -3.5,
				
				3,(float) -3.5,
				(float) 3.5,(float) -3.5,
				
				(float) 3.5,(float) -3.5,
				(float)3.5,(float) -5.5,
				
				(float)3.5,(float) -5.5,
				(float)3,(float) -5.5,
				
				//7
				//////
					4,-3,
					2,-3,
					
					2,-3,
					2,(float) -2.5,
					
					2,(float) -2.5,
					3,(float) -2.5,
					
					3,(float) -2.5,
					3,-1,
					/////
					3,-1,
					(float)3.5,-1,
					
					(float)3.5,-1,
					(float)3.5, (float) -2.5,
					
					(float)3.5, (float) -2.5,
					4,(float) -2.5,
					
					4,(float) -2.5,
					4,-3,
					
					 //8
					(float)-3.5,1,
					(float) -3.5,(float) 2.5,
					
					(float) -3.5,(float) 2.5,
					-3,(float) 2.5,
					
					-3,(float) 2.5,
					-3,1,
					
					-3,1,
					(float)-3.5,1,
					
					 //9
					//////
					(float)-1.5,-2,
						-2,-2,
						
						-2,-2,
						-2,2,
						
						-2,2,
						(float) -1.5,2,
						
						(float) -1.5,2,
						(float) -1.5,(float) 0.5,
						/////
						(float) -1.5,(float) 0.5,
						0,(float) 0.5,
						
						0,(float) 0.5,
						0,(float) -0.5,
						
						0,(float) -0.5,
						(float) -1.5,(float) -0.5,
						
						(float) -1.5,(float) -0.5,
						(float) -1.5,-2,
						 //10
						(float)2.5,(float) 0.5,
						(float) 2.5,(float) 2.5,
						
						(float) 2.5,(float) 2.5,
						(float) 3.5,(float) 2.5,
						
						(float) 3.5,(float) 2.5,
						(float) 3.5,(float) 0.5,
						
						(float) 2.5,(float) 0.5,
						(float)2.5,(float) 0.5,
						
						 //11
						(float)-3.5,3,
						(float) -3.5,(float) 5.5,
						
						(float) -3.5,(float) 5.5,
						-3,(float) 5.5,
						
						-3,(float) 5.5,
						-3,3,
						
						-3,3,
						(float) -3.5,3,
						
						 //12
						 (float)-2.5,(float) 3.5,
						(float) -2.5,(float) 5.5,
						
						(float) -2.5,(float) 5.5,
						(float) -1.5,(float) 5.5,
						
						(float) -1.5,(float) 5.5,
						(float) -1.5,(float) 3.5,
						
						(float) -1.5,(float) 3.5,
						(float) -2.5,(float) 3.5,
						
						 //13
						-2,(float) 2.5,
						-2,3,
						
						-2,3,
						(float) 1.5,3,
						
						(float) 1.5,3,
						(float) 1.5,(float) 2.5,
						
						(float) 1.5,(float) 2.5,
						-2,(float) 2.5,
						
						  //14
						(float)2.5,3,
						(float) 2.5,(float) 5.5,
						
						(float) 2.5,(float) 5.5,
						(float) 3.5,(float) 5.5,
						
						(float) 3.5,(float) 5.5,
						(float) 3.5,3,
						
						(float) 3.5,3,
						(float) 2.5,3,
						
						  //15
						(float)0.75,(float) -1.5,
						(float)0.75,(float) 1.5,
						
						(float)0.75,(float) 1.5,
						(float) 1.75,(float) 1.5,
						
						(float) 1.75,(float) 1.5,
						(float) 1.75,(float) -1.5,
						
						(float) 1.75,(float) -1.5,
						(float)0.75,(float) -1.5,
						
						 //16
						(float)0.5,(float) 0.5,
						(float)0.5,2,
						
						(float)0.5,2,
						2,2,
						
						2,2,
						2,-2,
						
						2,-2,
						(float) 0.5,-2,
						
						(float) 0.5,(float) -0.5,
						

						 //17
						-1,6,
						-1,(float) 3.5,
						
						-1,(float) 3.5,
				        (float) 1.5,(float) 3.5,
				        
				        (float) 1.5,6,
				        
				        //18
						-4,0,
						(float) -2.5,0,
						
						(float) -2.5,0,
						(float) -2.5,(float) 0.5,
				        
						(float) -2.5,(float) 0.5,
						-4,(float) 0.5,
						
						  //19
						4,(float) -0.5,
						(float) 2.5,(float) -0.5,
						
						(float) 2.5,(float) -0.5,
						(float) 2.5,0,
				        
						(float) 2.5,0,
						4,0,
						
						  //20
						-1,-6,
						-1,(float) -3.5,
						
						-1,(float) -3.5,
						(float) 1.5,(float) -3.5,
				        
						(float) 1.5,(float) -3.5,
						(float) 1.5,-6,
				        
				        
				        
	
		
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
	//1
	gl.glColor4f(0, 0, 1, 0);
	gl.glDrawArrays(GL10.GL_LINE_STRIP, 0,8);
	//2
	gl.glColor4f(0, 0, 1, 0);
	gl.glDrawArrays(GL10.GL_LINE_STRIP, 8,8);
	gl.glColor4f(0, 0, 1, 0);
	gl.glDrawArrays(GL10.GL_LINE_STRIP, 16,8);
	
	//3
	gl.glDrawArrays(GL10.GL_LINE_STRIP, 24,8);
	//4
	gl.glDrawArrays(GL10.GL_LINE_STRIP, 32,8);
	//5
	gl.glDrawArrays(GL10.GL_LINE_STRIP, 40,8);
	//6
	gl.glDrawArrays(GL10.GL_LINE_STRIP, 48,8);
	
	//7
		gl.glColor4f(0, 0, 1, 0);
		gl.glDrawArrays(GL10.GL_LINE_STRIP, 56,8);
		gl.glColor4f(0, 0, 1, 0);
		gl.glDrawArrays(GL10.GL_LINE_STRIP, 64,8);
		
	//8
	gl.glDrawArrays(GL10.GL_LINE_STRIP, 72,8);
	
	//9
			gl.glColor4f(0, 0, 1, 0);
			gl.glDrawArrays(GL10.GL_LINE_STRIP, 80,8);
			gl.glColor4f(0, 0, 1, 0);
			gl.glDrawArrays(GL10.GL_LINE_STRIP, 88,8);
			
			//10
			gl.glDrawArrays(GL10.GL_LINE_STRIP, 96,8);
			
			//11
			gl.glDrawArrays(GL10.GL_LINE_STRIP, 104,8);
			
			//12
			gl.glDrawArrays(GL10.GL_LINE_STRIP, 112,8);
			
			//13
			gl.glDrawArrays(GL10.GL_LINE_STRIP, 120,8);
			
			//14
			gl.glDrawArrays(GL10.GL_LINE_STRIP, 128,8);
			
			//15
			gl.glDrawArrays(GL10.GL_LINE_STRIP, 136,8);
			
			//16
			gl.glDrawArrays(GL10.GL_LINE_STRIP, 144,9);
			
			//17
			gl.glDrawArrays(GL10.GL_LINE_STRIP, 153,5);
			
			//18
			gl.glDrawArrays(GL10.GL_LINE_STRIP, 158,6);
			
			//19
			gl.glDrawArrays(GL10.GL_LINE_STRIP, 164,6);
			
			//20
			gl.glDrawArrays(GL10.GL_LINE_STRIP, 170,6);
	
	
	/*gl.glColor4f(0, 0, 1, 0);
	gl.glDrawArrays(GL10.GL_LINE_STRIP, 8,4);*/

	gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
}
}