package transformation;

import com.jogamp.opengl.GL2;

public class Ligne {
    private Vertex v1, v2;

    public Ligne(Vertex v1, Vertex v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public Vertex getV1() {
        return v1;
    }

    public void setV1(Vertex v1) {
        this.v1 = v1;
    }

    public Vertex getV2() {
        return v2;
    }

    public void setV2(Vertex v2) {
        this.v2 = v2;
    }

    public void draw(GL2 gl) {
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex2d(v1.getX(), v1.getY());  
        gl.glVertex2d(v2.getX(), v2.getY());  
        gl.glEnd();
    }
}
