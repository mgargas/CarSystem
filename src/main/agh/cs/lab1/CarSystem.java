package agh.cs.lab1;

import java.util.LinkedHashMap;
import java.util.Map;

public class CarSystem {
    public static void main(String args[]){

        try {
            MoveDirection[] directions = OptionParser.parse(args);
        Map<Position,HayStack> hayStack = new LinkedHashMap<>();
        hayStack.put(new Position(-4,-4),new HayStack(new Position(-4,-4)));
        hayStack.put(new Position(7,7),new HayStack(new Position(7,7)));
        hayStack.put(new Position(3,6),new HayStack(new Position(3,6)));
        hayStack.put(new Position(2,0),new HayStack(new Position(2,0)));
            IWorldMap map = new UnboundedMap(hayStack);
            map.place(new Car(map));
            map.place(new Car(map,3,4));
            map.run(directions);
            //map.showCars();
            System.out.println(map.toString());
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }

        /*
        MoveDirection[] directions = OptionParser.parse(args);
        IWorldMap map = new RectangularMap(10, 4);
        map.place(new Car(map));
        map.place(new Car(map,3,4));
        map.run(directions);
        System.out.println(map.toString());
        */





    }
}




