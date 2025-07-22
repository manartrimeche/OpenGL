package camera;

import com.jogamp.opengl.GL2; // Import nécessaire pour GL2

import java.util.ArrayList;
import java.util.List;


public class MyCube3D {
    private List<Triangle> triangles;
    List<MyCouleur> couleurtriangles = new ArrayList<>();

    public MyCube3D(float size) {
        triangles = new ArrayList<>();

        // Définition des sommets du cube
        Vertex v0 = new Vertex(-size / 2, -size / 2, size / 2); // 0
        Vertex v1 = new Vertex(size / 2, -size / 2, size / 2);  // 1
        Vertex v2 = new Vertex(size / 2, size / 2, size / 2);   // 2
        Vertex v3 = new Vertex(-size / 2, size / 2, size / 2);  // 3
        Vertex v4 = new Vertex(-size / 2, -size / 2, -size / 2); // 4
        Vertex v5 = new Vertex(size / 2, -size / 2, -size / 2);  // 5
        Vertex v6 = new Vertex(size / 2, size / 2, -size / 2);   // 6
        Vertex v7 = new Vertex(-size / 2, size / 2, -size / 2);  // 7

        // Création des faces du cube (deux triangles par face)
        // Face avant
        float r = (float) Math.random();
        float g = (float) Math.random();
        float b = (float) Math.random();
        couleurtriangles.add(new MyCouleur(r,g,b));
        triangles.add(new Triangle(v0, v1, v2));
        couleurtriangles.add(new MyCouleur(r,g,b));
        triangles.add(new Triangle(v0, v2, v3));

        // Face arrière
         r = (float) Math.random();
         g = (float) Math.random();
         b = (float) Math.random();
        couleurtriangles.add(new MyCouleur(r,g,b));
        triangles.add(new Triangle(v4, v6, v5)); //ordre important
        couleurtriangles.add(new MyCouleur(r,g,b));
        triangles.add(new Triangle(v4, v7, v6)); //ordre important

        // Face gauche
        r = (float) Math.random();
        g = (float) Math.random();
        b = (float) Math.random();
        couleurtriangles.add(new MyCouleur(r,g,b));
        triangles.add(new Triangle(v0, v3, v7));
        couleurtriangles.add(new MyCouleur(r,g,b));
        triangles.add(new Triangle(v0, v7, v4));

        // Face droite
        r = (float) Math.random();
        g = (float) Math.random();
        b = (float) Math.random();
        couleurtriangles.add(new MyCouleur(r,g,b));
        triangles.add(new Triangle(v1, v5, v6));
        couleurtriangles.add(new MyCouleur(r,g,b));
        triangles.add(new Triangle(v1, v6, v2));

        // Face haut
        r = (float) Math.random();
        g = (float) Math.random();
        b = (float) Math.random();
        couleurtriangles.add(new MyCouleur(r,g,b));
        triangles.add(new Triangle(v3, v2, v6));
        couleurtriangles.add(new MyCouleur(r,g,b));
        triangles.add(new Triangle(v3, v6, v7));

        // Face bas
        r = (float) Math.random();
        g = (float) Math.random();
        b = (float) Math.random();
        couleurtriangles.add(new MyCouleur(r,g,b));
        triangles.add(new Triangle(v0, v5, v1));
        couleurtriangles.add(new MyCouleur(r,g,b));
        triangles.add(new Triangle(v0, v4, v5));
    }

    public List<Triangle> getTriangles() {
        return triangles;
    }

    public void draw(GL2 gl) { // Méthode draw qui prend un objet GL2 en paramètre
        gl.glBegin(GL2.GL_TRIANGLES);
        int i=0;
        for (Triangle triangle : triangles) {
        	 gl.glColor3f(couleurtriangles.get(i).getR(), couleurtriangles.get(i).getV(), couleurtriangles.get(i).getB()); // Couleur du sommet           
            Normal normal = triangle.calculateNormal(); // Calcul de la normale
            gl.glNormal3f(normal.getX(), normal.getY(), normal.getZ());     // Définition de la normale
            gl.glVertex3f(triangle.getVertex(0).x, triangle.getVertex(0).y, triangle.getVertex(0).z);
            gl.glVertex3f(triangle.getVertex(1).x, triangle.getVertex(1).y, triangle.getVertex(1).z);
            gl.glVertex3f(triangle.getVertex(2).x, triangle.getVertex(2).y, triangle.getVertex(2).z);
            i++;
        }
        gl.glEnd();
    }
}
