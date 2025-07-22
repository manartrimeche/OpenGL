package camera;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.jogamp.opengl.GL2;

public class TriangleFan {
	List<Vertex> tab = new ArrayList<>();
	List<MyCouleur> tabCouleur = new ArrayList<>();

	public void addTriangleFan(Vertex v1) {
		tab.add(v1);
		float r = (float) Math.random();
		float g = (float) Math.random();
		float b = (float) Math.random();
		tabCouleur.add(new MyCouleur(r, g, b));
	}

	public void addTriangleFan(float[] apex) {
		tab.add(new Vertex(apex));
		float r = (float) Math.random();
		float g = (float) Math.random();
		float b = (float) Math.random();
		tabCouleur.add(new MyCouleur(r, g, b));
	}

	public void addTriangleFan(float f, float height, float g1) {
		tab.add(new Vertex(f, height, g1));
		float r = (float) Math.random();
		float g = (float) Math.random();
		float b = (float) Math.random();
		tabCouleur.add(new MyCouleur(r, g, b));

	}

	public void draw(GL2 gl) {

		gl.glBegin(GL2.GL_TRIANGLE_FAN);
		gl.glNormal3f(0.0f, -1.0f, 0.0f);
		int i = 0;
		for (Vertex vertexIndex : tab) {
			// Couleur aléatoire pour chaque segment de la base
			gl.glColor3f(tabCouleur.get(i).getR(), tabCouleur.get(i).getV(), tabCouleur.get(i).getB()); // Couleur du																						// sommet
			i++;
			float[] v = { vertexIndex.x, vertexIndex.y, vertexIndex.z };
			gl.glVertex3fv(v, 0);
		}
		gl.glEnd();
	}

	public Vertex getVertex(int i) {
		return tab.get(i);
	}

	public void setVertex(int i, Vertex v1) {
		tab.set(i, v1);
	}

	@Override
	public String toString() {
		return "Triangle [tab=" + tab + "]\n";
	}

}
