package transformation;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import java.util.ArrayList;
import java.util.List;

public class Scene implements GLEventListener {
    private List<Ligne> cadran; // Pour stocker les lignes du cadran
    private Ligne aiguilleHeures; // Aiguille des heures
    private Ligne aiguilleMinutes; // Aiguille des minutes
    private Ligne aiguilleSecondes; // Aiguille des secondes

    public Scene() {
        cadran = new ArrayList<>();
        initCadran(); // Initialiser cadre
        // Initialiser aiguilles
        aiguilleHeures = new Ligne(new Vertex(0, 0), new Vertex(0, 0.5f));
        aiguilleMinutes = new Ligne(new Vertex(0, 0), new Vertex(0, 0.8f));
        aiguilleSecondes = new Ligne(new Vertex(0, 0), new Vertex(0, 0.9f)); // Aiguille sec
    }

    private void initCadran() {
        // Créer un polygone (12 côtés)
        int nbCotes = 12;
        double angle = 2 * Math.PI / nbCotes;
        double rayon = 1.0;

        for (int i = 0; i < nbCotes; i++) {
            double x1 = rayon * Math.cos(i * angle);
            double y1 = rayon * Math.sin(i * angle);
            double x2 = rayon * Math.cos((i + 1) * angle);
            double y2 = rayon * Math.sin((i + 1) * angle);

            cadran.add(new Ligne(new Vertex((float) x1, (float) y1), new Vertex((float) x2, (float) y2)));
        }
    }

    @Override
    public void init(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f); // Fond blanc
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);

        updateAiguilles(); // Màj aiguilles

        // Dessiner le cadran
        gl.glColor3f(0, 0, 0); // Couleur noire
        for (Ligne ligne : cadran) {
            ligne.draw(gl);
        }

        // Dessiner les aiguilles
        gl.glColor3f(1, 0, 0); // rouge pour heures
        aiguilleHeures.draw(gl);

        gl.glColor3f(0, 0, 1); // bleue pour minutes
        aiguilleMinutes.draw(gl);

        gl.glColor3f(0, 1, 0); // verte pour secondes
        aiguilleSecondes.draw(gl); // Dessiner aiguille sec

        gl.glFlush();
    }

    private void updateAiguilles() {
        long curTime = System.currentTimeMillis();
        float seconde = (curTime / 1000) % 60; // sec act
        float minute = (curTime / 60000) % 60; //  min act
        float heure = ((curTime / (60 * 60000)) % 12) + 1; // h act

        // Convert h,m ,s (en rad)
        float angleHeures = (float) Math.toRadians((heure % 12) * 30 + (minute / 60) * 30);
        float angleMinutes = (float) Math.toRadians(minute * 6);
        float angleSecondes = (float) Math.toRadians(seconde * 6); // 6° par seconde

        // rot en h
        float[][] matRotationHeures = new float[3][3];
        Transformation.my2dMRotation(matRotationHeures, angleHeures);
        Vertex extremiteHeures = Transformation.my2dTransformationVertex(matRotationHeures, new Vertex(0, 0.5f));
        aiguilleHeures.setV2(extremiteHeures);
        // rot en min
        float[][] matRotationMinutes = new float[3][3];
        Transformation.my2dMRotation(matRotationMinutes, angleMinutes);
        Vertex extremiteMinutes = Transformation.my2dTransformationVertex(matRotationMinutes, new Vertex(0, 0.8f));
        aiguilleMinutes.setV2(extremiteMinutes);

        // Rot en secondes
        float[][] matRotationSecondes = new float[3][3];
        Transformation.my2dMRotation(matRotationSecondes, angleSecondes);
        Vertex extremiteSecondes = Transformation.my2dTransformationVertex(matRotationSecondes, new Vertex(0, 0.9f));
        aiguilleSecondes.setV2(extremiteSecondes);
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    }
}
