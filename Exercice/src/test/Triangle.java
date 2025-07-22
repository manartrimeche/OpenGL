package test;

import com.jogamp.opengl.GL2;

public class Triangle {
	Vertex v1, v2, v3;

    public Triangle(Vertex v1, Vertex v2, Vertex v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    public void draw(GL2 gl) {
        gl.glBegin(GL2.GL_TRIANGLES);
        gl.glColor3f(1.0f, 0.0f, 0.0f); // Rouge
        gl.glVertex2d(v1.x, v1.y);
        gl.glColor3f(0.0f, 1.0f, 0.0f); // Vert
        gl.glVertex2d(v2.x, v2.y);
        gl.glColor3f(0.0f, 0.0f, 1.0f); // Bleu
        gl.glVertex2d(v3.x, v3.y);
        gl.glEnd();
    }
    public static Vertex calculerCentreCercleCirconscrit(Triangle t) {
	    Vertex a = t.v1;
	    Vertex b = t.v2;
	    Vertex c = t.v3;

	    // Calcul des déterminants
	    float d = 2 * (a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y));
	    if (d == 0) {
	        return null; // Les points sont alignés, pas de cercle circonscrit
	    }

	    float aSq = a.x * a.x + a.y * a.y;
	    float bSq = b.x * b.x + b.y * b.y;
	    float cSq = c.x * c.x + c.y * c.y;

	    float x = (aSq * (b.y - c.y) + bSq * (c.y - a.y) + cSq * (a.y - b.y)) / d;
	    float y = (aSq * (c.x - b.x) + bSq * (a.x - c.x) + cSq * (b.x - a.x)) / d;

	    return new Vertex(x, y);
	}

}
