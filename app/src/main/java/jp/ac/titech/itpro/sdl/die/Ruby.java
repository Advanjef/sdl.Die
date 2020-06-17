package jp.ac.titech.itpro.sdl.die;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;


public class Ruby implements Obj{

    private final float[] VERTICES = {
            // Guide
            // left -1 <- 0 -> 1 right
            // bottom -1 <- 0 -> 1 top
            // back -1 <- 0 -> 1 front

            // Top
            0,                         (float) 0.2, 0,                        // center
            sin(0, 0.52),  (float) 0.2, cos(0, 0.52),  // top-front
            sin(2, 0.52),  (float) 0.2, cos(2, 0.52),  // top-front-right
            sin(4, 0.52),  (float) 0.2, cos(4, 0.52),  // top-right
            sin(6, 0.52),  (float) 0.2, cos(6, 0.52),  // top-back-right
            sin(8, 0.52),  (float) 0.2, cos(8, 0.52),  // top-back
            sin(10, 0.52), (float) 0.2, cos(10, 0.52), // top-back-left
            sin(12, 0.52), (float) 0.2, cos(12, 0.52), // top-left
            sin(14, 0.52), (float) 0.2, cos(14, 0.52), // top-front-left
            sin(16, 0.52), (float) 0.2, cos(16, 0.52), // top-front

            // Count down
            sin(0, 0.52),  (float) 0.2,   cos(0, 0.52),  // top-front
            sin(1, 1.0),   (float) -0.13, cos(1, 1.0),   // down
            sin(2, 0.52),  (float) 0.2,   cos(2, 0.52),  // top-front
            sin(2, 0.52),  (float) 0.2,   cos(2, 0.52),  // top-front-right
            sin(3, 1.0),   (float) -0.13, cos(3, 1.0),   // down
            sin(4, 0.52),  (float) 0.2,   cos(4, 0.52),  // top-right
            sin(4, 0.52),  (float) 0.2,   cos(4, 0.52),  // top-right
            sin(5, 1.0),   (float) -0.13, cos(5, 1.0),   // down
            sin(6, 0.52),  (float) 0.2,   cos(6, 0.52),  // top-back-
            sin(6, 0.52),  (float) 0.2,   cos(6, 0.52),  // top-back-right
            sin(7, 1.0),   (float) -0.13, cos(7, 1.0),   // down
            sin(8, 0.52),  (float) 0.2,   cos(8, 0.52),  // top-back
            sin(8, 0.52),  (float) 0.2,   cos(8, 0.52),  // top-back
            sin(9, 1.0),   (float) -0.13, cos(9, 1.0),   // down
            sin(10, 0.52), (float) 0.2,   cos(10, 0.52), // top-back-
            sin(10, 0.52), (float) 0.2,   cos(10, 0.52), // top-back-left
            sin(11, 1.0),  (float) -0.13, cos(11, 1.0),  // down
            sin(12, 0.52), (float) 0.2,   cos(12, 0.52), // top-left
            sin(12, 0.52), (float) 0.2,   cos(12, 0.52), // top-left
            sin(13, 1.0),  (float) -0.13, cos(13, 1.0),  // down
            sin(14, 0.52), (float) 0.2,   cos(14, 0.52), // top-front
            sin(14, 0.52), (float) 0.2,   cos(14, 0.52), // top-front-left
            sin(15, 1.0),  (float) -0.13, cos(15, 1.0),  // down
            sin(16, 0.52), (float) 0.2,   cos(16, 0.52), // top-front


            // Count up
            sin(1, 1.0),   (float) -0.13, cos(1, 1.0),   // down
            sin(2, 0.52),  (float) 0.2,   cos(2, 0.52),  // top-front-right
            sin(3, 1.0),   (float) -0.13, cos(3, 1.0),   // down
            sin(3, 1.0),   (float) -0.13, cos(3, 1.0),   // down
            sin(4, 0.52),  (float) 0.2,   cos(4, 0.52),  // top-right
            sin(5, 1.0),   (float) -0.13, cos(5, 1.0),   // down
            sin(5, 1.0),   (float) -0.13, cos(5, 1.0),   // down
            sin(6, 0.52),  (float) 0.2,   cos(6, 0.52),  // top-back-right
            sin(7, 1.0),   (float) -0.13, cos(7, 1.0),   // down
            sin(7, 1.0),   (float) -0.13, cos(7, 1.0),   // down
            sin(8, 0.52),  (float) 0.2,   cos(8, 0.52),  // top-back
            sin(9, 1.0),   (float) -0.13, cos(9, 1.0),   // down
            sin(9, 1.0),   (float) -0.13, cos(9, 1.0),   // down
            sin(10, 0.52), (float) 0.2,   cos(10, 0.52), // top-back-left
            sin(11, 1.0),  (float) -0.13, cos(11, 1.0),  // down
            sin(11, 1.0),  (float) -0.13, cos(11, 1.0),  // down
            sin(12, 0.52), (float) 0.2,   cos(12, 0.52), // top-left
            sin(13, 1.0),  (float) -0.13, cos(13, 1.0),  // down
            sin(13, 1.0),  (float) -0.13, cos(13, 1.0),  // down
            sin(14, 0.52), (float) 0.2,   cos(14, 0.52), // top-front-left
            sin(15, 1.0),  (float) -0.13, cos(15, 1.0),  // down
            sin(15, 1.0),  (float) -0.13, cos(15, 1.0),  // down
            sin(16, 0.52), (float) 0.2,   cos(16, 0.52), // top-front
            sin(1, 1.0),   (float) -0.13, cos(1, 1.0),   // down

            // Bottom
            0,                         -1,            0,
            sin(1, 1.0),   (float) -0.13, cos(1, 1.0),   // down
            sin(3, 1.0),   (float) -0.13, cos(3, 1.0),   // down
            0,                                 -1,     0,
            sin(3, 1.0),   (float) -0.13, cos(3, 1.0),   // down
            sin(5, 1.0),   (float) -0.13, cos(5, 1.0),   // down
            0,                                 -1,     0,
            sin(5, 1.0),   (float) -0.13, cos(5, 1.0),   // down
            sin(7, 1.0),   (float) -0.13, cos(7, 1.0),   // down
            0,                                 -1,     0,
            sin(7, 1.0),   (float) -0.13, cos(7, 1.0),   // down
            sin(9, 1.0),   (float) -0.13, cos(9, 1.0),   // down
            0,                                 -1,     0,
            sin(9, 1.0),   (float) -0.13, cos(9, 1.0),   // down
            sin(11, 1.0),  (float) -0.13, cos(11, 1.0),  // down
            0,                                 -1,     0,
            sin(11, 1.0),  (float) -0.13, cos(11, 1.0),  // down
            sin(13, 1.0),  (float) -0.13, cos(13, 1.0),  // down
            0,                                 -1,     0,
            sin(13, 1.0),  (float) -0.13, cos(13, 1.0),  // down
            sin(15, 1.0),  (float) -0.13, cos(15, 1.0),  // down
            0,                                 -1,     0,
            sin(15, 1.0),  (float) -0.13, cos(15, 1.0),  // down
            sin(1, 1.0),   (float) -0.13, cos(1, 1.0),   // down
            0,                                 -1,     0,
            sin(1, 1.0),   (float) -0.13, cos(1, 1.0),   // down
    };

    private final FloatBuffer vbuf;

    private static float TOP_REF = (float) 0.56640623692483;
    private static float TOP_TOP = (float) 0.82412618862202;
    private static float BOTTOM_REF = (float) 0.65342060399011;
    private static float BOTTOM_TOP = (float) -0.75699505565176;

    Ruby() {
        vbuf = ByteBuffer
                .allocateDirect(VERTICES.length * 4)
                .order(ByteOrder.nativeOrder())
                .asFloatBuffer();
        vbuf.put(VERTICES);
        vbuf.position(0);
    }

    private float cos(int step, double length) {
        return (float) (Math.cos(Math.PI * step / 8) * length);
    }

    private float sin(int step, double length) {
        return (float) (Math.sin(Math.PI * step / 8) * length);
    }

    @Override
    public void draw(GL10 gl) {
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vbuf);

        // Guide
        // left -1 <- 0 -> 1 right
        // bottom -1 <- 0 -> 1 top
        // back -1 <- 0 -> 1 front

        // Top
        gl.glNormal3f(0, 1, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 0, 10);

        gl.glNormal3f(sin(1, TOP_REF), TOP_TOP, cos(1, TOP_REF));
        gl.glDrawArrays(GL10.GL_TRIANGLES, 10, 3);
        gl.glNormal3f(sin(3, TOP_REF), TOP_TOP, cos(3, TOP_REF));
        gl.glDrawArrays(GL10.GL_TRIANGLES, 13, 3);
        gl.glNormal3f(sin(5, TOP_REF), TOP_TOP, cos(5, TOP_REF));
        gl.glDrawArrays(GL10.GL_TRIANGLES, 16, 3);
        gl.glNormal3f(sin(7, TOP_REF), TOP_TOP, cos(7, TOP_REF));
        gl.glDrawArrays(GL10.GL_TRIANGLES, 19, 3);
        gl.glNormal3f(sin(9, TOP_REF), TOP_TOP, cos(9, TOP_REF));
        gl.glDrawArrays(GL10.GL_TRIANGLES, 22, 3);
        gl.glNormal3f(sin(11, TOP_REF), TOP_TOP, cos(11, TOP_REF));
        gl.glDrawArrays(GL10.GL_TRIANGLES, 25, 3);
        gl.glNormal3f(sin(13, TOP_REF), TOP_TOP, cos(13, TOP_REF));
        gl.glDrawArrays(GL10.GL_TRIANGLES, 28, 3);
        gl.glNormal3f(sin(15, TOP_REF), TOP_TOP, cos(15, TOP_REF));
        gl.glDrawArrays(GL10.GL_TRIANGLES, 31, 3);

        gl.glNormal3f(sin(0, TOP_REF), TOP_TOP, cos(0, TOP_REF));
        gl.glDrawArrays(GL10.GL_TRIANGLES, 34, 3);
        gl.glNormal3f(sin(2, TOP_REF), TOP_TOP, cos(2, TOP_REF));
        gl.glDrawArrays(GL10.GL_TRIANGLES, 37, 3);
        gl.glNormal3f(sin(4, TOP_REF), TOP_TOP, cos(4, TOP_REF));
        gl.glDrawArrays(GL10.GL_TRIANGLES, 40, 3);
        gl.glNormal3f(sin(6, TOP_REF), TOP_TOP, cos(6, TOP_REF));
        gl.glDrawArrays(GL10.GL_TRIANGLES, 43, 3);
        gl.glNormal3f(sin(8, TOP_REF), TOP_TOP, cos(8, TOP_REF));
        gl.glDrawArrays(GL10.GL_TRIANGLES, 46, 3);
        gl.glNormal3f(sin(10, TOP_REF), TOP_TOP, cos(10, TOP_REF));
        gl.glDrawArrays(GL10.GL_TRIANGLES, 49, 3);
        gl.glNormal3f(sin(12, TOP_REF), TOP_TOP, cos(12, TOP_REF));
        gl.glDrawArrays(GL10.GL_TRIANGLES, 52, 3);
        gl.glNormal3f(sin(14, TOP_REF), TOP_TOP, cos(14, TOP_REF));
        gl.glDrawArrays(GL10.GL_TRIANGLES, 55, 3);

        gl.glNormal3f(sin(1, BOTTOM_REF), BOTTOM_TOP, cos(1, BOTTOM_REF));
        gl.glDrawArrays(GL10.GL_TRIANGLES, 58, 3);
        gl.glNormal3f(sin(3, BOTTOM_REF), BOTTOM_TOP, cos(3, BOTTOM_REF));
        gl.glDrawArrays(GL10.GL_TRIANGLES, 61, 3);
        gl.glNormal3f(sin(5, BOTTOM_REF), BOTTOM_TOP, cos(5, BOTTOM_REF));
        gl.glDrawArrays(GL10.GL_TRIANGLES, 64, 3);
        gl.glNormal3f(sin(7, BOTTOM_REF), BOTTOM_TOP, cos(7, BOTTOM_REF));
        gl.glDrawArrays(GL10.GL_TRIANGLES, 67, 3);
        gl.glNormal3f(sin(9, BOTTOM_REF), BOTTOM_TOP, cos(9, BOTTOM_REF));
        gl.glDrawArrays(GL10.GL_TRIANGLES, 70, 3);
        gl.glNormal3f(sin(11, BOTTOM_REF), BOTTOM_TOP, cos(11, BOTTOM_REF));
        gl.glDrawArrays(GL10.GL_TRIANGLES, 73, 3);
        gl.glNormal3f(sin(13, BOTTOM_REF), BOTTOM_TOP, cos(13, BOTTOM_REF));
        gl.glDrawArrays(GL10.GL_TRIANGLES, 76, 3);
        gl.glNormal3f(sin(15, BOTTOM_REF), BOTTOM_TOP, cos(15, BOTTOM_REF));
        gl.glDrawArrays(GL10.GL_TRIANGLES, 79, 3);
    }
}
