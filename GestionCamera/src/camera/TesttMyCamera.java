package camera;

import javax.swing.JFrame;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.Animator;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TesttMyCamera {
    public static void main(String[] args) {
        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        final GLCapabilities capabilities = new GLCapabilities(profile);
        final GLCanvas canvas = new GLCanvas(capabilities);
        
        Scene Scene = new Scene();
        canvas.addGLEventListener(Scene);
        canvas.setSize(800, 500);
        
        // Add keyboard controls
        canvas.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyChar()) {
                    case 'a': // Rotation du parent et rotation vers la droite
                        System.out.println("a - rotation vers la droite");
                        Scene.incrementangleSegment1(5.0f);
                        Scene.setCameraRotationDirection(true); // Rotation vers la droite
                        break;
                    case 'b': // Rotation de l'enfant et rotation vers la gauche
                        System.out.println("b - rotation vers la gauche");
                        Scene.incrementangleSegment2(5.0f);
                        Scene.setCameraRotationDirection(false); // Rotation vers la gauche
                        break;
                    case 'c': // Rotation du petit-enfant et arrêt de la rotation
                        System.out.println("c - arrêt de la rotation");
                        Scene.incrementangleSegment3(5.0f);
                        Scene.stopCameraRotation(); // Arrêt de la rotation
                        break;
                }
                canvas.display();
            }
        });
        
        // Make sure the canvas is focusable to receive keyboard events
        canvas.setFocusable(true);
        canvas.requestFocus();
        
        final JFrame frame = new JFrame("Exemple Camera");
        frame.add(canvas);
        frame.setSize(frame.getPreferredSize());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        final Animator animator = new Animator(canvas);
        animator.start();
    }
}
