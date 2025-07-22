package camera;

import com.jogamp.opengl.GL2;
import java.util.ArrayList;
import java.util.List;



public class MyCylinder {
    private List<Triangle> triangles;
    private List<MyCouleur> couleurTriangles;
    private float radius;
    private float height;
    private int slices;

    public MyCylinder(float radius, float height, int slices) {
        this.radius = radius;
        this.height = height;
        this.slices = slices;
        this.triangles = new ArrayList<>();
        couleurTriangles=new ArrayList<>();
        construct();
    }

    private void construct() {
        // Construction des triangles latéraux
        for (int i = 0; i < slices; i++) {
            float angle1 = (float) (2 * Math.PI * i / slices);
            float angle2 = (float) (2 * Math.PI * (i + 1) / slices);
            Vertex v1 = new Vertex(radius * (float) Math.cos(angle1), height / 2, radius * (float) Math.sin(angle1));
            Vertex v2 = new Vertex(radius * (float) Math.cos(angle2), height / 2, radius * (float) Math.sin(angle2));
            Vertex v3 = new Vertex(radius * (float) Math.cos(angle1), -height / 2, radius * (float) Math.sin(angle1));
            Vertex v4 = new Vertex(radius * (float) Math.cos(angle2), -height / 2, radius * (float) Math.sin(angle2));
            float r = (float) Math.random();
            float g = (float) Math.random();
            float b = (float) Math.random();
            couleurTriangles.add(new MyCouleur(r,g,b));
            
            triangles.add(new Triangle(v1, v2, v3));
             r = (float) Math.random();
             g = (float) Math.random();
             b = (float) Math.random();
             couleurTriangles.add(new MyCouleur(r,g,b));
            triangles.add(new Triangle(v2, v4, v3));
        }

        // Construction du cercle supérieur
        Vertex centerTop = new Vertex(0, height / 2, 0);
        for (int i = 0; i < slices; i++) {
            float angle1 = (float) (2 * Math.PI * i / slices);
            float angle2 = (float) (2 * Math.PI * (i + 1) / slices);
            Vertex v1 = new Vertex(radius * (float) Math.cos(angle1), height / 2, radius * (float) Math.sin(angle1));
            Vertex v2 = new Vertex(radius * (float) Math.cos(angle2), height / 2, radius * (float) Math.sin(angle2));
            float r = (float) Math.random();
            float g = (float) Math.random();
            float b = (float) Math.random();
            couleurTriangles.add(new MyCouleur(r,g,b));
            triangles.add(new Triangle(centerTop, v1, v2));
        }

        // Construction du cercle inférieur
        Vertex centerBottom = new Vertex(0, -height / 2, 0);
        for (int i = 0; i < slices; i++) {
            float angle1 = (float) (2 * Math.PI * i / slices);
            float angle2 = (float) (2 * Math.PI * (i + 1) / slices);
            Vertex v1 = new Vertex(radius * (float) Math.cos(angle1), -height / 2, radius * (float) Math.sin(angle1));
            Vertex v2 = new Vertex(radius * (float) Math.cos(angle2), -height / 2, radius * (float) Math.sin(angle2));
            float r = (float) Math.random();
            float g = (float) Math.random();
            float b = (float) Math.random();
            couleurTriangles.add(new MyCouleur(r,g,b));
            triangles.add(new Triangle(centerBottom, v1, v2));
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