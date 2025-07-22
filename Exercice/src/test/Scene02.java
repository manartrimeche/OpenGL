package test;

import com.jogamp.opengl.*;

import java.util.ArrayList;
import java.util.List;

public class Scene02 implements GLEventListener {
    private Vertex p1, p2; // Deux points pour former une ligne
    private Transformation transformation;
    private Vertex centreRotation; 

    public Scene02() {
        p1 = new Vertex(0.0f, 0.0f); // Centre de rotation
        p2 = new Vertex(0.5f, 0.0f); // Point initial de la ligne
        transformation = new Transformation();
        centreRotation = p1; // La ligne tourne autour de p1
    }

    @Override
    public void init(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);

        transformation.updateRotation(); // Mise à jour de l'angle

        gl.glPushMatrix();
        applyMatrixTransformation(gl, centreRotation, transformation.getAngle());
        drawLine(gl, p1, p2);
        gl.glPopMatrix();

        gl.glFlush();
    }

    @Override
    public void dispose(GLAutoDrawable arg0) {
        // Rien à libérer ici
    }

    @Override
    public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
        // Pas besoin de changement
    }

    // Méthode pour appliquer la transformation matricielle H = T(-Cx, -Cy) * R(v) * T(Cx, Cy)
    private void applyMatrixTransformation(GL2 gl, Vertex center, float angle) {
        if (center == null) return;

        gl.glTranslatef(center.x, center.y, 0);  // T(Cx, Cy)
        gl.glRotatef(angle, 0, 0, 1);            // R(v)
        gl.glTranslatef(-center.x, -center.y, 0); // T(-Cx, -Cy)
    }

    // Méthode pour dessiner une ligne entre deux points
    private void drawLine(GL2 gl, Vertex v1, Vertex v2) {
        gl.glBegin(GL2.GL_LINES);
        gl.glColor3f(1.0f, 0.0f, 0.0f); // Rouge
        gl.glVertex2f(v1.x, v1.y);
        gl.glVertex2f(v2.x, v2.y);
        gl.glEnd();
    }
}
