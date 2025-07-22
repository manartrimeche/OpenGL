package camera;

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
    private void update(GL2 gl, float posX, float posY, float posZ, float tragetX, float tragetY, float tragetZ,
			float upX, float upY, float upZ) {
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
    /*
    // Déplacer la caméra vers l'avant ou l'arrière
    public void moveForward(float distance) {
        float[] direction = normalize(subtract(target, position));
        position = add(position, multiply(direction, distance));
        target = add(target, multiply(direction, distance));
    }

    // Déplacer la caméra latéralement (gauche/droite)
    public void moveSideways(float distance) {
        float[] direction = normalize(subtract(target, position));
        float[] right = normalize(cross(direction, up));
        position = add(position, multiply(right, distance));
        target = add(target, multiply(right, distance));
    }

    // Faire pivoter la caméra autour de l'axe Y (rotation horizontale)
    public void rotateY(float angle) {
        float[] direction = subtract(target, position);
        float[] rotatedDirection = rotateY(direction, angle);
        target = add(position, rotatedDirection);
    }

    // Faire pivoter la caméra autour de l'axe X (rotation verticale)
    public void rotateX(float angle) {
        float[] direction = subtract(target, position);
        float[] rotatedDirection = rotateX(direction, angle);
        target = add(position, rotatedDirection);
        up = rotateX(up, angle); // Mettre à jour le vecteur up
    }

    // Méthodes utilitaires pour les opérations vectorielles
    private float[] add(float[] a, float[] b) {
        return new float[]{a[0] + b[0], a[1] + b[1], a[2] + b[2]};
    }

    private float[] subtract(float[] a, float[] b) {
        return new float[]{a[0] - b[0], a[1] - b[1], a[2] - b[2]};
    }

    private float[] multiply(float[] v, float scalar) {
        return new float[]{v[0] * scalar, v[1] * scalar, v[2] * scalar};
    }

    private float[] cross(float[] a, float[] b) {
        return new float[]{
            a[1] * b[2] - a[2] * b[1],
            a[2] * b[0] - a[0] * b[2],
            a[0] * b[1] - a[1] * b[0]
        };
    }

    private float[] normalize(float[] v) {
        float length = (float) Math.sqrt(v[0] * v[0] + v[1] * v[1] + v[2] * v[2]);
        return new float[]{v[0] / length, v[1] / length, v[2] / length};
    }

    private float[] rotateY(float[] v, float angle) {
        float rad = (float) Math.toRadians(angle);
        float cos = (float) Math.cos(rad);
        float sin = (float) Math.sin(rad);
        return new float[]{
            v[0] * cos + v[2] * sin,
            v[1],
            -v[0] * sin + v[2] * cos
        };
    }

    private float[] rotateX(float[] v, float angle) {
        float rad = (float) Math.toRadians(angle);
        float cos = (float) Math.cos(rad);
        float sin = (float) Math.sin(rad);
        return new float[]{
            v[0],
            v[1] * cos - v[2] * sin,
            v[1] * sin + v[2] * cos
        };
    }*/
}