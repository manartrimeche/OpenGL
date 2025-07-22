package test;


public class Vertex {
    float x, y;

    public Vertex(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public float [] toTable()
    {
    float table []=new float[3];
    table[0]=this.x;
    table[1]=this.y;
    table[2]=1;
    return table;
    }
public float getX() {
return x;
}
public void setX(float x) {
this.x = x;
}
public float getY() {
return y;
}
public void setY(float y) {
this.y = y;
}
   
}