package transformation;

import com.jogamp.opengl.GL2;

public class Cone {
    private float radius;
    private float height;
    private int slices;

    public Cone(float radius, float height, int slices) {
        this.radius = radius;
        this.height = height;
        this.slices = slices;
    }

    public void draw(GL2 gl) {
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, -height / 2, 0.0f); // Translation vers le bas
        
        gl.glBegin(GL2.GL_TRIANGLE_FAN);
        
        // Sommet du cône
        gl.glVertex3f(0.0f, height, 0.0f);
        
        // Base du cône
        for (int i = 0; i <= slices; i++) {
            double angle = 2.0 * Math.PI * i / slices;
            float x = (float) (radius * Math.cos(angle));
            float z = (float) (radius * Math.sin(angle));
            gl.glVertex3f(x, 0.0f, z);
        }
        gl.glEnd();

        // Dessin de la base du cône
        gl.glBegin(GL2.GL_TRIANGLE_FAN);
        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        for (int i = 0; i <= slices; i++) {
            double angle = 2.0 * Math.PI * i / slices;
            float x = (float) (radius * Math.cos(angle));
            float z = (float) (radius * Math.sin(angle));
            gl.glVertex3f(x, 0.0f, z);
        }
        gl.glEnd();
        
        gl.glPopMatrix();
    }
}
