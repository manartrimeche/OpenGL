package transformation;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.GLU;

public class Camera {
    private float[] position; // Position de la caméra
    private float[] target;   // Point visé
    private float[] up;       // Vecteur up

    public Camera(float[] position, float[] target, float[] up) {
        this.position = position.clone();
        this.target = target.clone();
        this.up = up.clone();
    }
    public Camera() {
        this.position = new float[3];
        this.target = new float[3];
        this.up = new float[3];
    }
    
    public void update(GL2 gl) {
		GLU glu = new GLU();
		glu.gluLookAt(position[0], position[1], position[2],
				target[0], target[1], target[2],
				up[0], up[1], up[2]);
	}
    private void update(GL2 gl, float posX, float posY, float posZ, float tragetX, float tragetY, float tragetZ,float upX, float upY, float upZ) {
		GLU glu = new GLU();
		glu.gluLookAt(posX, posY, posZ, tragetX, tragetY, tragetZ, upX, upY, upZ);
	}
  // Getters
    public float[] getPosition() { return position; }
    public float[] getTarget() { return target; }
    public float[] getUp() { return up; }
 // setters
    public void setPosition(float posX,float posY,float posZ) {
    	position[0]=posX;
    	position[1]=posY;
    	position[2]=posZ;
    }
    public void setTarget(float posX,float posY,float posZ) {
    	target[0]=posX;
    target[1]=posY;
    target[2]=posZ; 
    }
    public void setUp(float posX,float posY,float posZ) {
    	up[0]=posX;
    	up[1]=posY;
    	up[2]=posZ; 
    	}

}