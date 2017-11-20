package agh.cs.lab1;

public class BoundingBox {
    private int minx;
    private int miny;
    private int maxx;
    private int maxy;
    BoundingBox(Position p1){
        minx=p1.x;
        miny=p1.y;
        maxx=p1.x;
        maxy=p1.y;
    }
    public void grow(Position p){
        minx=Math.min(p.x,minx);
        miny=Math.min(p.y,miny);
        maxx=Math.max(p.x,maxx);
        maxy=Math.max(p.y,maxy);
    }
    public Position getLeftCorner(){
        return new Position(minx,miny);
    }
    public Position getRightCorner(){
        return new Position(maxx,maxy);
    }
}
