package agh.cs.lab1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

abstract class AbstractWorldMap implements IWorldMap,IPositionChangeObserver {
    protected Map<Position,Car> cars = new LinkedHashMap<>();
    @Override
    public void run(MoveDirection[] directions) {
        List<Car> carList = new ArrayList<>(cars.values());
        for(int i=0;i<directions.length;i++){
            Car car = carList.get(i%carList.size());
            //Position oldPosition = car.getPosition();
            car.move(directions[i]);
            //Position newPosition = car.getPosition();
            //cars.remove(oldPosition);
            //cars.put(newPosition,car);
            carList.set(i % carList.size(), car);
        }
    }

    @Override
    public boolean isOccupied(Position position) {
        return (objectAt(position) != null);
    }

    @Override
    public void positionChanged(Position oldPosition, Position newPosition){
        Car car = cars.get(oldPosition);
        cars.remove(oldPosition);
        cars.put(newPosition,car);
    }
}
