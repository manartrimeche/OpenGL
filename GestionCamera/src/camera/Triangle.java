package camera;

import java.util.Arrays;

import com.jogamp.opengl.GL2;

public class Triangle {
	Vertex tab[]=new Vertex[3];
    public Triangle(Vertex v1, Vertex v2, Vertex v3) {
        this.tab[0] = v1;
        this.tab[1] = v2;
        this.tab[2] = v3;
    }

    public Triangle(float[] apex, float[] basePoint1, float[] basePoint2) {
    	tab[0]=new Vertex(apex);
    	tab[1]=new Vertex(basePoint1);
    	tab[2]=new Vertex(basePoint2);
	}

	public Triangle(float f, float height, float g, float x1, float h, float z1, float x2, float i, float z2) {
		tab[0]=new Vertex(f,  height,  g);
		tab[1]=new Vertex(x1,  h,  z1);
		tab[2]=new Vertex(x2,  i,  z2);
	}
	public Normal calculateNormal() {
		Normal v1v2 = new Normal(tab[1].x - tab[0].x, tab[1].y - tab[0].y, tab[1].z - tab[0].z);
		Normal v1v3 = new Normal(tab[2].x - tab[0].x, tab[2].y - tab[0].y, tab[2].z - tab[0].z);
        //Vector3f normal = new Vector3f();
		v1v2.cross( v1v3); // Produit vectoriel
        //normal.normalize(); // Normalisation
        return v1v2;
    }
	public void draw(GL2 gl) {		
        gl.glBegin(GL2.GL_TRIANGLES);
        for (Vertex vertexIndex : tab) {
			float[]v= {vertexIndex.x,vertexIndex.y,vertexIndex.z};
			gl.glVertex3fv(v, 0);
		}
        gl.glEnd();
    }
    
    public Vertex getVertex(int i) {
    	return tab[i];
    }

	public void setVertex(int i, Vertex v1) {
		tab[i]=v1;
	}

	@Override
	public String toString() {
		return "Triangle [tab=" + Arrays.toString(tab) + "]\n";
	}
}
