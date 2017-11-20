package agh.cs.lab1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MapDirectionTest {
    @Test
    public void previousTest(){
        assertEquals(MapDirection.North.next(),MapDirection.East);
    }
}
