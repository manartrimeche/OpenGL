package camera;
import com.jogamp.opengl.*;
import com.jogamp.opengl.glu.GLU;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class Scene implements GLEventListener {

    private Camera camera;
    private MyCone myCone;
    private float angle = 0.0f;
    private float radius = 5.0f;

    public Scene() {
        camera = new Camera();
        camera.setTarget(0.0f, 0.0f, 0.0f);
        myCone = new MyCone(1.0f, 2.0f, 32);
    }

    @Override
    public void init(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        gl.glEnable(GL.GL_DEPTH_TEST);
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();
        
        float camX = (float)(Math.sin(angle) * radius);
        float camZ = (float)(Math.cos(angle) * radius);
        float camY = 2.0f;
        
        camera.setPosition(camX, camY, camZ);
        camera.setUp(0, 1, 0);
        camera.update(gl);
        
        myCone.drawCone(gl);
        
        angle += 0.01f;  
        
        gl.glFlush();
    }

    @Override
    public void dispose(GLAutoDrawable arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL2 gl = drawable.getGL().getGL2();
        
        if (height <= 0) height = 1;  
        
        float aspect = (float) width / (float) height;
        
        gl.glViewport(0, 0, width, height);
        
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        
        GLU glu = new GLU();
        glu.gluPerspective(45.0f, aspect, 0.1f, 100.0f);
        
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
    }
}