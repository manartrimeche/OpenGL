package transformation;

import com.jogamp.opengl.GL2;

public class Triangle {
    private Vertex v1, v2, v3;

    public Triangle(Vertex v1, Vertex v2, Vertex v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    public void draw(GL2 gl) {
        gl.glBegin(GL2.GL_TRIANGLES);
        gl.glColor3f(1.0f, 0.0f, 0.0f); // Rouge
        gl.glVertex3f(v1.getX(), v1.getY(), v1.getZ());
        gl.glColor3f(0.0f, 1.0f, 0.0f); // Vert
        gl.glVertex3f(v2.getX(), v2.getY(), v2.getZ());
        gl.glColor3f(0.0f, 0.0f, 1.0f); // Bleu
        gl.glVertex3f(v3.getX(), v3.getY(), v3.getZ());
        gl.glEnd();
    }

    // Méthode pour dessiner le triangle avec une seule couleur
    public void drawWithColor(GL2 gl, float r, float g, float b) {
        gl.glBegin(GL2.GL_TRIANGLES);
        gl.glColor3f(r, g, b);
        gl.glVertex3f(v1.getX(), v1.getY(), v1.getZ());
        gl.glVertex3f(v2.getX(), v2.getY(), v2.getZ());
        gl.glVertex3f(v3.getX(), v3.getY(), v3.getZ());
        gl.glEnd();
    }

    // Calcul du centre du cercle circonscrit au triangle
    public static Vertex calculerCentreCercleCirconscrit(Triangle t) {
        Vertex a = t.v1;
        Vertex b = t.v2;
        Vertex c = t.v3;

        float d = 2 * (a.getX() * (b.getY() - c.getY()) + 
                       b.getX() * (c.getY() - a.getY()) + 
                       c.getX() * (a.getY() - b.getY()));
        if (d == 0) {
            return null; // Si d est nul, pas de cercle circonscrit
        }

        float aSq = a.getX() * a.getX() + a.getY() * a.getY();
        float bSq = b.getX() * b.getX() + b.getY() * b.getY();
        float cSq = c.getX() * c.getX() + c.getY() * c.getY();

        float x = (aSq * (b.getY() - c.getY()) + 
                   bSq * (c.getY() - a.getY()) + 
                   cSq * (a.getY() - b.getY())) / d;
        float y = (aSq * (c.getX() - b.getX()) + 
                   bSq * (a.getX() - c.getX()) + 
                   cSq * (b.getX() - a.getX())) / d;

        return new Vertex(x, y, 0);
    }

    // Getters
    public Vertex getV1() { return v1; }
    public Vertex getV2() { return v2; }
    public Vertex getV3() { return v3; }
}
