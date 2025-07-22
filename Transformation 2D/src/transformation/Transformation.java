package transformation;

public class Transformation {
    public static void my2dClearMatrix(float[][] mat) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                mat[i][j] = 0.0f;
            }
        }
    }

    public static void my2dMIdentity(float[][] mat) {
        my2dClearMatrix(mat);
        for (int i = 0; i < 3; i++) {
            mat[i][i] = 1.0f;
        }
    }

    public static Vertex my2dTransformationVertex(float[][] mat, Vertex v) {
        float x1 = v.x * mat[0][0] + v.y * mat[0][1] + 1 * mat[0][2];
        float y1 = v.x * mat[1][0] + v.y * mat[1][1] + 1 * mat[1][2];
        return new Vertex(x1, y1);
    }

    public static void my2dMTranslation(float[][] mat, float dx, float dy) {
        my2dClearMatrix(mat);
        for (int i = 0; i < 3; i++) {
            mat[i][i] = 1.0f;
        }
        mat[0][2] = dx;
        mat[1][2] = dy;
    }

    public static void my2dMRotation(float[][] mat, float delta) {
        float myCos = (float) Math.cos(delta);
        float mySin = (float) Math.sin(delta);
        my2dClearMatrix(mat);
        for (int i = 0; i < 3; i++) {
            mat[i][i] = 1.0f;
        }
        mat[0][0] = myCos;
        mat[0][1] = mySin;
        mat[1][0] = -mySin;
        mat[1][1] = myCos;
    }

    public static void my2dMEchelle(float[][] mat, float dx, float dy) {
        my2dClearMatrix(mat);
        for (int i = 0; i < 3; i++) {
            mat[i][i] = 1.0f;
        }
        mat[0][0] = dx;
        mat[1][1] = dy;
    }
}