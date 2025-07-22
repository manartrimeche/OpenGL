package transformation;
import com.jogamp.opengl.GL2;
import java.util.ArrayList;
import java.util.List;

public class MyPolygon2D {
    private List<Vertex> vertices;  
    private int numberOfVertices;   
    private float radius;           
    private float centerX, centerY; 

    public MyPolygon2D(int numberOfVertices, float centerX, float centerY, float radius) {
        this.numberOfVertices = numberOfVertices;
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.vertices = new ArrayList<>();
        generateVertices();
    }

    public static class Vertex {
        public float x, y;

        public Vertex(float x, float y) {
            this.x = x;
            this.y = y;
        }
    }

    private void generateVertices() {
        float angleStep = 2 * (float)Math.PI / numberOfVertices;
        for (int i = 0; i < numberOfVertices; i++) {
            float angle = angleStep * i;
            float x = centerX + radius * (float)Math.cos(angle);
            float y = centerY + radius * (float)Math.sin(angle);
            vertices.add(new Vertex(x, y));
        }
    }

 
    public List<Vertex> getVertices() {
        return vertices;
    }

  
    public void draw(GL2 gl) {
        gl.glBegin(GL2.GL_POLYGON);
        for (Vertex vertex : vertices) {
            gl.glVertex2f(vertex.x, vertex.y);  
        }
        gl.glEnd();  
    }
}
