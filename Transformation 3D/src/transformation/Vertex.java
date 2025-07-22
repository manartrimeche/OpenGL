package transformation;

public class Vertex {
    public float x;
    public float y;
    public float z;
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getZ() {
		return z;
	}
	public void setZ(float z) {
		this.z = z;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	public Vertex(float x, float y,float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public Vertex(float[] apex) {
		this.x = apex[0];
		this.y = apex[1];
		this.z = apex[2];
	}
	@Override
	public String toString() {
		return "Vertex [x=" + x + ", y=" + y + ", z=" + z + "]\n";
	}
    
}