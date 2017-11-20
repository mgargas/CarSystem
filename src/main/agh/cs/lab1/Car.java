package agh.cs.lab1;

public class Car {
    private MapDirection mapDirection;
    private Position p;
    private IWorldMap map;

    public Car(IWorldMap map){
        this.mapDirection = MapDirection.North;
        this.p = new Position(2,2);
        this.map=map;
    }
    public Car(IWorldMap map, int x, int y){
        this.p = new Position(x,y);
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
        return p;
    }
    public MapDirection getDirection() {
        return mapDirection;
    }
    public void move(MoveDirection moveDirection){

        Position n = new Position(0,0);
        n=n.add(p);
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
                        if(map.canMoveTo(n)) this.p = n;
                        break;

                    case East:
                        n=n.add(new Position(1,0));
                        if(map.canMoveTo(n)) this.p = n;
                        break;

                    case South:
                        n=n.add(new Position(0,-1));
                        if(map.canMoveTo(n)) this.p = n;
                        break;

                    case West:
                        n=n.add(new Position(-1,0));
                        if(map.canMoveTo(n)) this.p=n;
                        break;

                }
                break;
            case Backward:
                switch (this.mapDirection){
                    case North:
                        n=n.add(new Position(0,-1));
                        if(map.canMoveTo(n)) this.p=n;
                        break;
                    case East:
                        n=n.add(new Position(-1,0));
                        if(map.canMoveTo(n)) this.p=n;
                        break;
                    case South:
                        n=n.add(new Position(0,1));
                        if(map.canMoveTo(n)) this.p=n;
                        break;
                    case West:
                        n=n.add(new Position(1,0));
                        if(map.canMoveTo(n)) this.p=n;
                        break;
                }
                break;
            }

        }
    }

