package com.example.a323_9_cubocolorinterracion;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import javax.microedition.khronos.opengles.GL10;
public class Cubo {
    /*** 3 ---------2
     *  * /| /| * / | / |
     * 7 --------- 6 |* | | | |
     * | 0 ------|-- 1 * | / | /
     * |/ |/ * 4 --------- 5  */
    /* Las coordenadas cartesianas (x, y, z) */
    private float vertices[] = new float[] {
            //////CUBO1

// Frente
            (float) - 0.5, -1, (float) 0.5, // 4 0
            (float) 0.5,-1, (float) 0.5, // 5 1
            0, 1,0, // 6 2
            0, 1, 0, // 7 3
// Atrás
           0, 1,0, // 3 4
            0, 1,0, // 2 5
            (float) 0.5,-1,(float) -0.5, // 1 6
            (float) -0.5,-1, (float) -0.5, // 0 7
// Izquierda
            (float) -0.5, -1, (float) -0.5, // 0 8
            (float) -0.5, -1, (float) 0.5, // 4 9
            0, 1, 0, // 7 10
             0, 1, 0, // 3 11

// Derecha
            (float) 0.5,-1, (float) 0.5, // 5 12
            (float) 0.5,-1,(float) -0.5, // 1 13
            0, 1,0, // 2 14
            0, 1, 0, // 6 15
// Abajo
            (float) -0.5, -1,(float)- 0.5, // 0 16
            (float) 0.5,-1,(float) -0.5, // 1 17
            (float) 0.5,-1,(float) 0.5, // 5 18
            (float) -0.5,-1, (float) -0.5, // 4 19
// Arriba
            0, 0, 0, // 7 20
            0, 0, 0, // 6 21
            0, 0,0, // 2 22
            0, 0,0, // 3 23


            //////CUBO2

// Frente
            (float) - 2, -1, (float) -1, // 4 0
            (float) -2,-1, (float) -1, // 5 1
            0, 1,0, // 6 2
            0, 1, 0, // 7 3
// Atrás
            0, 1,0, // 3 4
            0, 1,0, // 2 5
            (float) -1,-1,(float) -2, // 1 6
            (float) -2,-1, (float) -2, // 0 7
// Izquierda
            (float) -2, -1, (float) -2, // 0 8
            (float) -2, -1, (float) -1, // 4 9
            0, 1, 0, // 7 10
            0, 1, 0, // 3 11

// Derecha
            (float) -1,-1, (float) -1, // 5 12
            (float) -1,-1,(float) -1, // 1 13
            0, 1,0, // 2 14
            0, 1, 0, // 6 15
// Abajo
            0, 0, 0, // 0 16
            0, 0, 0,  // 1 17
            0, 0, 0,  // 5 18
            0, 0, 0,  // 4 19
// Arriba
            0, 0, 0, // 7 20
            0, 0, 0, // 6 21
            0, 0,0, // 2 22
            0, 0,0, // 3 23




    };
    /* Los colores x c/vértice (r,g,b,a) */
    byte maxColor = (byte)255;
    private byte colores[] = new byte[] {
// Frente - lila
            maxColor, 0, 0, 0, // 4 0
            maxColor, 0, 0, 0, // 5 1
            maxColor, 0, 0, 0, // 6 2
            maxColor, 0, 0, 0, // 7 3
// Atrás - amarillo
            maxColor, 0, 0, 0, // 4 0
            maxColor, 0, 0, 0, // 5 1
            maxColor, 0, 0, 0, // 6 2
            maxColor, 0, 0, 0, // 7 3
// Izquierda - celeste
            maxColor, 0, 0, 0, // 4 0
            maxColor, 0, 0, 0, // 5 1
            maxColor, 0, 0, 0, // 6 2
            maxColor, 0, 0, 0, // 7 3
// Derecha - rojo
            maxColor, 0, 0, 0, // 4 0
            maxColor, 0, 0, 0, // 5 1
            maxColor, 0, 0, 0, // 6 2
            maxColor, 0, 0, 0, // 7 3
// Abajo - azul
            0, 0, maxColor, maxColor, // 0 16
            0, 0, maxColor, maxColor, // 1 17
            0, 0, maxColor, maxColor, // 5 18
            0, 0, maxColor, maxColor, // 4 19
// Arriba - verde
            0, maxColor, 0, maxColor, // 7 20
            0, maxColor, 0, maxColor, // 6 21
            0, maxColor, 0, maxColor, // 2 22
            0, maxColor, 0, maxColor // 3 23
    };
    /* Indices */
    private short indices[] = new short [] {
            0, 1, 2, 0, 2, 3, // Frente
            4, 5, 6, 4, 6, 7, // Atrás
            8, 9, 10, 8, 10, 11, // Izquierda
            12, 13, 14, 12, 14, 15, // Derecha
            16, 17, 18, 16, 18, 19, // Abajo
            20, 21, 22, 20, 22, 23 // Arriba
    };
    private FloatBuffer bufVertices;
    private ByteBuffer bufColores;
    private ShortBuffer bufIndices;
    public Cubo() {
        /* Lee los vértices */
        ByteBuffer bufByte = ByteBuffer.allocateDirect(vertices.length * 4);
        bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte nativo
        bufVertices = bufByte.asFloatBuffer(); // Convierte de byte a float
        bufVertices.put(vertices);
        bufVertices.rewind(); // puntero al principio del buffer
        /* Lee los colores */
        bufColores = ByteBuffer.allocateDirect(colores.length);
        bufColores.put(colores);
        bufColores.position(0); // puntero al principio del buffer
        /* Lee los indices */
        bufByte = ByteBuffer.allocateDirect(indices.length * 2);
        bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte nativo
        bufIndices = bufByte.asShortBuffer(); // Convierte de byte a short
        bufIndices.put(indices);
        bufIndices.rewind(); // puntero al principio del buffer
    }
    public void dibuja(GL10 gl) {
        /* Se habilita el acceso al arreglo de vértices */
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        /* Se habilita el acceso al arreglo de colores */
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
        /* Se especifica los datos del arreglo de vértices */
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
        /* Se especifica los datos del arreglo de colores */
        gl.glColorPointer(4, GL10.GL_UNSIGNED_BYTE, 0, bufColores);
        /* Se dibuja el cubo */
        gl.glDrawElements(GL10.GL_TRIANGLES, indices.length,
                GL10.GL_UNSIGNED_SHORT, bufIndices);
        /* Se deshabilita el acceso a los arreglos */
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
    }
}
