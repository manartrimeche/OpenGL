package camera;

import com.jogamp.opengl.GL2;
import java.util.ArrayList;
import java.util.List;

public class MySphere {
    private List<Triangle> triangles;
    private List<MyCouleur> couleurTriangles;
    private float rayon;
    private int slices;
    private int stacks;

    public MySphere(float radius, int slices, int stacks) {
        this.rayon = radius;
        this.slices = slices;
        this.stacks = stacks;
        this.triangles = new ArrayList<>();
        couleurTriangles=new ArrayList<>();
        construct();
    }

    private void construct() {
        for (int i = 0; i < stacks; i++) {
            double angLat = Math.PI * (-0.5 + (double) (i) / stacks); // Latitude
            double y0 = rayon * Math.sin(angLat); // Z coordinate
            double zr0 = rayon * Math.cos(angLat); // Radius at latitude

            double angLatNext = Math.PI * (-0.5 + (double) (i + 1) / stacks); // Latitude
            double y1 = rayon * Math.sin(angLatNext); // Z coordinate
            double zr1 = rayon * Math.cos(angLatNext); // Radius at latitude

            for (int j = 0; j < slices; j++) {
                double angLong = 2 * Math.PI * (double) (j) / slices; // Longitude
                double x0 = zr0 * Math.cos(angLong); // X coordinate
                double z0 = zr0 * Math.sin(angLong); // Y coordinate

                double angLongNext = 2 * Math.PI * (double) (j + 1) / slices; // Longitude
                double x1 = zr1 * Math.cos(angLongNext); // X coordinate
                double z1 = zr1 * Math.sin(angLongNext); // Y coordinate

                // Création des triangles
                Vertex v1 = new Vertex((float)x0,(float) y0,(float) z0);
                Vertex v2 = new Vertex((float)x1,(float) y1,(float) z1);
                Vertex v3 = new Vertex((float)x0, (float)y1, (float)z0);
                Vertex v4 = new Vertex((float)x1,(float) y0,(float) z1);
                
                float r = (float) Math.random();
                float g = (float) Math.random();
                float b = (float) Math.random();
                couleurTriangles.add(new MyCouleur(r,g,b));
                triangles.add(new Triangle(v1, v2, v3)); // Triangle supérieur
                
                r = (float) Math.random();
                g = (float) Math.random();
                b = (float) Math.random();
                couleurTriangles.add(new MyCouleur(r,g,b));
                triangles.add(new Triangle(v2, v4, v3)); // Triangle inférieur
            }
        }
    }

    public void draw(GL2 gl) {
    	int i=0;
        for (Triangle triangle : triangles) {
        	gl.glColor3f(couleurTriangles.get(i).getR(), couleurTriangles.get(i).getV(), couleurTriangles.get(i).getB()); // Couleur du sommet           
            triangle.draw(gl);
            i++;
        }
    }
}