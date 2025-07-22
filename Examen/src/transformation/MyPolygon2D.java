package transformation;
import java.util.ArrayList;
import java.util.List;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.GLU;
public class MyPolygon2D {
    private List<Vertex> vertices;  // Liste sommets 
    private int numberOfVertices;   // Nbre ommets
    private float radius;           // R cercle
    private float centerX, centerY; 

    public MyPolygon2D(int numberOfVertices, float centerX, float centerY, float radius) {
        this.numberOfVertices = numberOfVertices;
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.vertices = new ArrayList<>();
    }

    public static class Vertex {
        public float x, y;

        public Vertex(float x, float y) {
            this.x = x;
            this.y = y;
        }
    }
    public void draw(GL2 gl) {
    	int i=0;
        for (MyPolygon triangle : triangles) {
        	gl.glColor3f(couleurTriangles.get(i).getR(), couleurTriangles.get(i).getV(), couleurTriangles.get(i).getB()); // Couleur du sommet           
            triangle.draw(gl);
            i++;
        }
    }

    public List<Vertex> getVertices() {
        return vertices;
    }



}
