package camera;

public class Normal {
    private float x, y, z;

    // Constructeur
    public Normal(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
        normalize(); // Normaliser le vecteur
    }

    // Normaliser le vecteur (le rendre unitaire)
    public void normalize() {
        float length = (float) Math.sqrt(x * x + y * y + z * z);
        if (length != 0) {
            x /= length;
            y /= length;
            z /= length;
        }
    }

    // Getters
    public float getX() { return x; }
    public float getY() { return y; }
    public float getZ() { return z; }

    // Méthode pour calculer le produit scalaire avec un autre vecteur
    public float dot(Normal other) {
        return x * other.x + y * other.y + z * other.z;
    }

    // Méthode pour calculer le produit vectoriel avec un autre vecteur
    public Normal cross(Normal other) {
        float crossX = y * other.z - z * other.y;
        float crossY = z * other.x - x * other.z;
        float crossZ = x * other.y - y * other.x;
        return new Normal(crossX, crossY, crossZ);
    }

    @Override
    public String toString() {
        return "Normal(" + x + ", " + y + ", " + z + ")";
    }

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

	public void setZ(float z) {
		this.z = z;
	}
    
    
}