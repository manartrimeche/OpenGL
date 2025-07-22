package camera;

import java.util.ArrayList;
import java.util.List;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;

public class MyCone {
	float radius = 1.0f;
    float height = 2.0f;
    int slices = 32; // Nombre de triangles
    public MyCone(float radius, float height, int slices) {
    	this.radius=radius;
    	this.height=height;
    	this.slices=slices;
    	buildCone();
    }
	List<Triangle> triangles = new ArrayList<>();
	List<MyCouleur> couleurtriangles = new ArrayList<>();
	TriangleFan trianglesBase = new TriangleFan();
	public void buildCone() {
		for (int i = 0; i < slices; i++) {
            // Couleur aléatoire pour chaque triangle        
            double angle1 = 2 * Math.PI * i / slices;
            float x1 = radius * (float) Math.cos(angle1);
            float z1 = radius * (float) Math.sin(angle1);
 
            double angle2 = 2 * Math.PI * (i + 1) / slices;
            float x2 = radius * (float) Math.cos(angle2);
            float z2 = radius * (float) Math.sin(angle2);
         // Couleur aléatoire pour chaque triangle
            float r = (float) Math.random();
            float g = (float) Math.random();
            float b = (float) Math.random();
            couleurtriangles.add(new MyCouleur(r,g,b));
            Triangle t=new Triangle(0.0f, height, 0.0f,x1, 0.0f, z1,x2, 0.0f, z2) ;
            triangles.add(t);
        }
		trianglesBase.addTriangleFan(0.0f, 0.0f, 0.0f);
        for (int i = 0; i <= slices; i++) {
            double angle = 2 * Math.PI * i / slices;
            float x = radius * (float) Math.cos(angle);
            float z = radius * (float) Math.sin(angle);
            trianglesBase.addTriangleFan(x, 0.0f, z);
        }

    }
	public void drawCone(GL2 gl) {
        // Dessiner la surface du cône
        for (int i = 0; i < triangles.size(); i++) {            
            // Sommet du cône
            gl.glColor3f(couleurtriangles.get(i).getR(), couleurtriangles.get(i).getV(), couleurtriangles.get(i).getB()); // Couleur du sommet           
            // Points de la base
            triangles.get(i).draw(gl);
        }
        // Dessiner la base du cône      
        gl.glNormal3f(0.0f, -1.0f, 0.0f); // Normale vers le bas
        trianglesBase.draw(gl);
    }
}
