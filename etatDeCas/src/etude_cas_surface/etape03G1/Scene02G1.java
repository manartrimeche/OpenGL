package etude_cas_surface.etape03G1;

import com.jogamp.opengl.*;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class Scene02G1 implements GLEventListener {
	private List<Vertex> sommets;
	private List<Vertex> sommetsInt; // Liste pour stocker les sommets
	private List<Triangle> triangles; // Liste de listes de sommets pour les triangles
	private List<Ligne> lignes;
	public Scene02G1() {
		// Initialisation des sommets du dodécagone (exemple)
		sommets = new ArrayList<>();
		sommetsInt = new ArrayList<>();
		triangles = new ArrayList<>();
		lignes = new ArrayList<>();
		int rayon = 150; // Rayon du dodécagone
		for (int i = 0; i < 12; i++) {
			double angle = 2 * Math.PI * i / 12;
			float x = (float) (rayon * Math.cos(angle));
			float y = (float) (rayon * Math.sin(angle));
			sommets.add(new Vertex(x, y));
		}
		diviserEnTriangles();
	}

	@Override
	public void init(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		GL2 gl = drawable.getGL().getGL2();
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		gl.glOrtho(-width / 2, width / 2, -height / 2, height / 2, -1, 1);
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();
	}
	@Override
	public void display(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		gl.glClear(GL.GL_COLOR_BUFFER_BIT);

		dessinerTriangles(gl);

		gl.glFlush();
	}
	@Override
	public void dispose(GLAutoDrawable drawable) {
	}

	private void diviserEnTriangles() {
		Vertex centre = new Vertex(0,0);
		for (int i = 0; i < sommets.size(); i++) {
			Vertex V1=sommets.get(i);
			Vertex V2=sommets.get((i+1)%12);
			Triangle T = new Triangle (centre , V1,V2);
			Vertex Vint = Triangle.calculerCentreCercleCirconscrit(T);
		    this.triangles.add(new Triangle (Vint, V1,V2));	
		    lignes.add(new Ligne(centre,V1));	
		}
	}


	private void dessinerTriangles(GL2 gl) {
		float r=0.0f;
		for (Triangle  triangle : triangles) {
			gl.glColor3f(1, 0.0f, 0.0f);
			triangle.draw(gl);
		}
		for (Ligne  ligne : lignes) {
			gl.glColor3f(1, 0.0f, 0.0f);
			ligne.draw(gl);
			}
	}
}