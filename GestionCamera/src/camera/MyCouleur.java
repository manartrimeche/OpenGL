package camera;

public class MyCouleur {
	private float r,v,b;

	public MyCouleur(float r, float v, float b) {
		super();
		this.r = r;
		this.v = v;
		this.b = b;
	}

	
	
	public float getR() {
		return r;
	}



	public void setR(float r) {
		this.r = r;
	}



	public float getV() {
		return v;
	}



	public void setV(float v) {
		this.v = v;
	}



	public float getB() {
		return b;
	}



	public void setB(float b) {
		this.b = b;
	}



	@Override
	public String toString() {
		return "MyCouleur [r=" + r + ", v=" + v + ", b=" + b + "]";
	}
	

}
