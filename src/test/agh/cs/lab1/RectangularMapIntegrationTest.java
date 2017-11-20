package agh.cs.lab1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RectangularMapIntegrationTest {
    @Test
    public void MapTest(){
        String[] command = {"f","b","r", "l", "f", "f", "r", "r", "f" ,"f" ,"f", "f", "f" ,"f", "f", "f"};
        MoveDirection[] directions = OptionParser.parse(command);
        IWorldMap map = new RectangularMap(10, 4);
        map.place(new Car(map));
        map.place(new Car(map,3,4));
        map.run(directions);
        assertEquals(map.objectAt(new Position(2,0)).toString(),"v");
        assertEquals(map.objectAt(new Position(3,4)).toString(),"^");
    }
}
