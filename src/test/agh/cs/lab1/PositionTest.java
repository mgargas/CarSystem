package agh.cs.lab1;

import org.junit.Assert;
import org.junit.Test;

public class PositionTest {
    @Test
    public void toStringTest(){
        Assert.assertEquals(new Position(1,1).toString(), "(1,1)");
        Assert.assertEquals(new Position(2,2).toString(),"(2,2)");
    }
}
