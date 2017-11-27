package agh.cs.lab1;

import java.util.HashSet;

public class Car    {
    private MapDirection mapDirection;
    private Position position;
    private IWorldMap map;
    HashSet<IPositionChangeObserver> observers = new HashSet<>();
    public void addObserver(IPositionChangeObserver observer){
        observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer){
        observers.remove(observer);
    }
    public void positionChanged(Position oldPosition, Position newPosition){
        for(IPositionChangeObserver observer : observers){
            observer.positionChanged(oldPosition,newPosition);
        }
    }
    public Car(IWorldMap map){
        this.mapDirection = MapDirection.North;
        this.position = new Position(2,2);
        this.map=map;
    }
    public Car(IWorldMap map, int x, int y){
        this.position = new Position(x,y);
        this.mapDirection = MapDirection.North;
        this.map=map;
    }
    @Override
    public String toString(){
        switch(this.mapDirection){
            case East:
                return ">";
            case South:
                return "v";
            case West:
                return "<";
            case North:
                return "^";
        }
        return null;
    }

    public Position getPosition() {
        return position;
    }
    public MapDirection getDirection() {
        return mapDirection;
    }
    public void move(MoveDirection moveDirection){
        Position oldPosition = position;
        Position n = new Position(0,0);
        n=n.add(position);
        switch (moveDirection){
            case Left:
                this.mapDirection = this.mapDirection.previous();
                break;
            case Right:
                this.mapDirection = this.mapDirection.next();
                break;
            case Forward:
                switch (this.mapDirection){
                    case North:
                        n=n.add(new Position(0,1));
                        if(map.canMoveTo(n)) this.position = n;
                        break;

                    case East:
                        n=n.add(new Position(1,0));
                        if(map.canMoveTo(n)) this.position = n;
                        break;

                    case South:
                        n=n.add(new Position(0,-1));
                        if(map.canMoveTo(n)) this.position = n;
                        break;

                    case West:
                        n=n.add(new Position(-1,0));
                        if(map.canMoveTo(n)) this.position =n;
                        break;

                }
                break;
            case Backward:
                switch (this.mapDirection){
                    case North:
                        n=n.add(new Position(0,-1));
                        if(map.canMoveTo(n)) this.position =n;
                        break;
                    case East:
                        n=n.add(new Position(-1,0));
                        if(map.canMoveTo(n)) this.position =n;
                        break;
                    case South:
                        n=n.add(new Position(0,1));
                        if(map.canMoveTo(n)) this.position =n;
                        break;
                    case West:
                        n=n.add(new Position(1,0));
                        if(map.canMoveTo(n)) this.position =n;
                        break;
                }
                break;
            }

        Position newPosition = position;
        positionChanged(oldPosition,newPosition);
        }
    }

