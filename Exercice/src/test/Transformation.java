package test;

public class Transformation {
    private float angle = 0.0f;

    public void updateRotation() {
        long curTime = System.currentTimeMillis();
        float seconde = (curTime / 1000) % 60;
        angle = seconde * 6; // 6° par seconde
    }

    public float getAngle() {
        return angle;
    }
}
