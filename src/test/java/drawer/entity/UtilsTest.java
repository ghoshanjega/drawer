package drawer.entity;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UtilsTest {

    @Test
    public void allPositive() {
        Assert.assertTrue(Utils.allPositive(0,1,2,3,4,5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void allPositiveWithNegativeParams() {
        Assert.assertTrue(Utils.allPositive(0,1,-2,3,4,5));
    }

    @Test
    public void calculateDistanceBetweenPoints() {
        Assert.assertEquals(7,Utils.calculateDistanceBetweenPoints(0,0,5,5),1);
    }

    @Test
    public void indexOfSmallest() {
        Assert.assertEquals(1, Utils.indexOfSmallest(new double[]{1.23,1.01,3.32,4.55}));
    }
}