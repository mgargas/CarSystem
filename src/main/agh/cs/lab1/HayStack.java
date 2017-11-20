package agh.cs.lab1;

public class HayStack {
    private Position position;
    HayStack(Position position){
        this.position=position;
    }

    public Position getPosition() {
        return position;
    }
    @Override
    public String toString(){
        return "S";
    }
}
