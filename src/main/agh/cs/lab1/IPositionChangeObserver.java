package agh.cs.lab1;

public interface IPositionChangeObserver {
    void positionChanged(Position oldPosition,Position newPosition);
    //void addObserver(IPositionChangeObserver o);
    //void removeObserver(IPositionChangeObserver o);
}
