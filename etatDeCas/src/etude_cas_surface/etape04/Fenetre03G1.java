package etude_cas_surface.etape04;

import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;

import javax.swing.JFrame;
import java.awt.BorderLayout;


public class Fenetre03G1 {

	public static void main(String[] args) {
		// ... (Initialisation JOGL et Scene comme avant)
		GLProfile glp = GLProfile.getDefault();
		GLCapabilities caps = new GLCapabilities(glp);
		GLCanvas canvas = new GLCanvas(caps);

		Scene02 scene = new Scene02(); // Instanciation de la scène
		canvas.addGLEventListener(scene);

		JFrame frame = new JFrame("Calcul de Surface");
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*JButton btnEtapeSuivante = new JButton("Étape suivante");
		btnEtapeSuivante.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				scene.etapeSuivante();
				canvas.repaint();
			}
		});
		JButton btnEtapePrecedente = new JButton("Étape precedente");
		btnEtapePrecedente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (scene.getEtape() > 1) {
					scene.setEtape(scene.getEtape() - 1);
					canvas.repaint(); // Important : redessine la scène
				}

			}
		});
		JPanel panel = new JPanel(new FlowLayout());
		panel.add(btnEtapePrecedente);
		panel.add(btnEtapeSuivante);
		frame.add(panel, BorderLayout.SOUTH);*/
		frame.add(canvas, BorderLayout.CENTER);

		frame.setVisible(true);
		FPSAnimator animator = new FPSAnimator(canvas, 60);
        animator.start();
	}
}