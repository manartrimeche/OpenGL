package transformation;
import com.jogamp.opengl.GL2;
public class Cylindre {
    private float radius;
    private float height;
    private int slices;
    private Vertex[] topVertices;
    private Vertex[] bottomVertices;
    private Vertex topCenter;
    private Vertex bottomCenter;
    private Triangle[] triangles;
    private float[][] triangleColors;

    public Cylindre(float radius, float height, int slices) {
        this.radius = radius;
        this.height = height;
        this.slices = slices;

        topVertices = new Vertex[slices];
        bottomVertices = new Vertex[slices];

        int totalTriangles = slices * 4;
        triangles = new Triangle[totalTriangles];
        triangleColors = new float[totalTriangles][3];
        topCenter = new Vertex(0, height, 0);
        bottomCenter = new Vertex(0, 0, 0);

        createVertices();
        createTriangles();
        generateColors();
    }

    private void createVertices() {
        float angleIncrement = (float) (2 * Math.PI / slices);

        for (int i = 0; i < slices; i++) {
            float angle = i * angleIncrement;
            float x = (float) (radius * Math.cos(angle));
            float z = (float) (radius * Math.sin(angle));

            topVertices[i] = new Vertex(x, height, z);

            bottomVertices[i] = new Vertex(x, 0, z);
        }
    }

    private void createTriangles() {
        for (int i = 0; i < slices; i++) {
            Vertex v1 = topCenter;
            Vertex v2 = topVertices[i];
            Vertex v3 = topVertices[(i + 1) % slices];
            triangles[i] = new Triangle(v1, v2, v3);
        }

        for (int i = 0; i < slices; i++) {
            Vertex v1 = bottomCenter;
            Vertex v2 = bottomVertices[(i + 1) % slices];
            Vertex v3 = bottomVertices[i];
            triangles[slices + i] = new Triangle(v1, v2, v3);
        }

        for (int i = 0; i < slices; i++) {
            Vertex v1 = topVertices[i];
            Vertex v2 = bottomVertices[i];
            Vertex v3 = bottomVertices[(i + 1) % slices];
            triangles[2 * slices + i] = new Triangle(v1, v2, v3);

            Vertex v4 = topVertices[i];
            Vertex v5 = bottomVertices[(i + 1) % slices];
            Vertex v6 = topVertices[(i + 1) % slices];
            triangles[3 * slices + i] = new Triangle(v4, v5, v6);
        }
    }

    private void generateColors() {
        for (int i = 0; i < triangles.length; i++) {
            
            triangleColors[i][0] = (float) (0.5 + 0.5 * Math.sin(0.1 * i));             
            triangleColors[i][1] = (float) (0.5 + 0.5 * Math.sin(0.1 * i + 2.0));       
            triangleColors[i][2] = (float) (0.5 + 0.5 * Math.sin(0.1 * i + 4.0));     
        }
    }

    public void draw(GL2 gl) {
        for (int i = 0; i < triangles.length; i++) {
            Triangle t = triangles[i];
            t.drawWithColor(gl, triangleColors[i][0], triangleColors[i][1], triangleColors[i][2]);
        }
    }
    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}
