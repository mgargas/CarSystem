package agh.cs.lab1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CarIntegrationTest {
    @Test
    public void CarTest() {
        IWorldMap map = new RectangularMap(4, 4);
        Car car1 = new Car(map);
        String[] command = {"right", "ble", "bleee", "forward", "f", "f"};
       // OptionParser optionParser = new OptionParser();
        //MoveDirection[] moveDirection = optionParser.parse(command);
        for (MoveDirection o : OptionParser.parse(command))
            car1.move(o);
        assertEquals(car1.getPosition().toString(),"(4,2)");
        assertEquals(car1.getDirection(),MapDirection.East);
    }
}
