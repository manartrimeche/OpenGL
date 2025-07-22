package transformation;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;
import javax.swing.JFrame;
import java.awt.BorderLayout;

public class Fenetre {

    public static void main(String[] args) {
        // Initialisation de JOGL
        GLProfile glp = GLProfile.getDefault();
        GLCapabilities caps = new GLCapabilities(glp);
        GLCanvas canvas = new GLCanvas(caps);

        // Création de la scène
        Scene scene = new Scene();
        canvas.addGLEventListener(scene);

        // Configuration de la fenêtre
        JFrame frame = new JFrame("Horloge 2D");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(canvas, BorderLayout.CENTER);
        frame.setVisible(true);

        // Animation à 60 FPS
        FPSAnimator animator = new FPSAnimator(canvas, 60);
        animator.start();
    }
}