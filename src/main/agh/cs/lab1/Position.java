package agh.cs.lab1;

class Position {
    final int x;
    final int y;

    public Position(int x,int y){
        this.x=x;
        this.y=y;
    }
 
    public String toString(){
        return "("+this.x+","+this.y+")";
    }
    public boolean smaller(Position other){
        if(this.x<=other.x && this.y<=other.y) return true;
        return false;
    }
    public boolean larger(Position other){
        if(this.x>=other.x && this.y>=other.y) return true;
        return false;
    }
    public Position add(Position other){
        Position p=new Position(this.x+other.x,this.y + other.y);
        return p;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (x != position.x) return false;
        return y == position.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

}
