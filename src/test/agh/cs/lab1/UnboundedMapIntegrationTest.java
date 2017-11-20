package agh.cs.lab1;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class UnboundedMapIntegrationTest {
    @Test
    public void UnboundedMapTest(){
        String[] command = {"f","b","r", "l", "f", "f", "r", "r", "f" ,"f" ,"f", "f", "f" ,"f", "f", "f"};
        MoveDirection[] directions = OptionParser.parse(command);
        Map<Position,HayStack> heyStack = new LinkedHashMap<>();
        heyStack.put(new Position(-4,-4),new HayStack(new Position(-4,-4)));
        heyStack.put(new Position(7,7),new HayStack(new Position(7,7)));
        heyStack.put(new Position(3,6),new HayStack(new Position(3,6)));
        heyStack.put(new Position(2,0),new HayStack(new Position(2,0)));
        IWorldMap map = new UnboundedMap(heyStack);
        map.place(new Car(map));
        map.place(new Car(map,3,4));
        map.run(directions);

        assertEquals(map.objectAt(new Position(2,1)).toString(),"v");
        assertEquals(map.objectAt(new Position(3,5)).toString(),"^");
    }


}
