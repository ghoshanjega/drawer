package drawer.entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {
    private Point point;

    @Before
    public void setUp() throws Exception {
        point = new Point(3, 3);
    }

    @Test
    public void getNeighbours() {
        int[][] expected_neighbours = new int[][]{new int[]{2,2},new int[]{3,2},new int[]{4,2},new int[]{4,3},new int[]{4,4},new int[]{3,4},new int[]{2,4},new int[]{2,3}};
        Assert.assertEquals(expected_neighbours,point.getNeighbours());
    }

    @Test
    public void getPoints() {
        Assert.assertArrayEquals(new int[] {3,3},point.getPoints());
    }

    @Test
    public void testEquals() {
        Point expectedPoint = new Point(3,3);
        Assert.assertEquals(expectedPoint,point);
    }
}