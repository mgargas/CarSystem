package agh.cs.lab1;

import java.util.*;

public class UnboundedMap extends AbstractWorldMap {
    Map<Position,HayStack> heyStacks=new LinkedHashMap<>();

    UnboundedMap(Map<Position,HayStack> heyStacks){
        this.heyStacks=heyStacks;
    }

    @Override
    public boolean canMoveTo(Position position){
        if(!isOccupied(position)) return true;
        return false;
    }
    @Override
    public boolean place(Car car){
        if(isOccupied(car.getPosition())) {
            throw new IllegalArgumentException(car.getPosition().toString() + " jest zajęte");
            //return false;
        }
        else{
            cars.put(car.getPosition(),car);
            return true;
        }
    }
/*
    @Override
    public void run(MoveDirection[] directions) {
        for(int i=0;i<directions.length;i++){
            Car temp = cars.get(i%cars.size());
            temp.move(directions[i]);
            cars.set(i % cars.size(), temp);
        }
    }

    @Override
    public boolean isOccupied(Position position) {
        if(objectAt(position)!=null) return true;
        return false;
    }
    */

    @Override
    public Object objectAt(Position position) {
        if(cars.get(position)!=null) return cars.get(position);
        else if(heyStacks.get(position)!=null) return heyStacks.get(position);
        return null;
    }

    @Override
    public String toString(){
        MapVisualizer mapVisualizer = new MapVisualizer();
        BoundingBox boundingBox;
        List<HayStack> hayStacksList =new ArrayList<>(heyStacks.values());
        List<Car>carsList=new ArrayList<>(cars.values());
        if(hayStacksList.get(0)!=null){
            Position firstObject = hayStacksList.get(0).getPosition();
            boundingBox = new BoundingBox(firstObject);
        }
        else if(carsList.get(0)!=null){
            Position firstObject = carsList.get(0).getPosition();
            boundingBox = new BoundingBox(firstObject);
        }
        else{
            boundingBox = new BoundingBox(new Position(0,0));
        }
        for(HayStack s : hayStacksList){
            boundingBox.grow(s.getPosition());
        }
        for(Car c: carsList){
            boundingBox.grow(c.getPosition());
        }
        return mapVisualizer.dump(this,boundingBox.getLeftCorner().add(new Position(-1,-1)),boundingBox.getRightCorner().add(new Position(1,1)));
    }
}
