package transformation;

public class Cube3D {
    private float l;
    public Vertex[] vertices;

    public float getL() {
        return l;
    }

    public void setL(float l) {
        this.l = l;
    }

    public Cube3D(float l) {
        this.l = l;
        vertices = new Vertex[]{
            new Vertex(0, 0, 0),
            new Vertex(l, 0, 0),
            new Vertex(l, l, 0),
            new Vertex(0, l, 0),
            new Vertex(0, 0, -l),
            new Vertex(l, 0, -l),
            new Vertex(l, l, -l),
            new Vertex(0, l, -l)
        };
    }
}
