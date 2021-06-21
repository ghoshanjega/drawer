package drawer.entity;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LineTest {

    @Test
    public void createHorizontal() {
        Line newLine =  new Line(1, 1, 1, 4);
        Assert.assertEquals(1,newLine.getX1());
    }

    @Test
    public void createDiagonal() {
        Line newLine =  new Line(1, 5, 1, 5);
        Assert.assertEquals(1,newLine.getX1());
    }

    @Test
    public void createLarge() {
        Line newLine =  new Line(1, 5, 100, 500);
        Assert.assertEquals(1,newLine.getX1());
    }


    @Test(expected = IllegalArgumentException.class)
    public void createWithNegativeNumbers()  {
        new Line(-1, 1, 1, 4);
    }


    @Test
    public void getPath() {
        Line newLine = new Line(1, 1, 1, 4);
        Point[] path = new Point[] {new Point(1,1),new Point(1,2),new Point(1,3),new Point(1,4)};
        Assert.assertArrayEquals(path,newLine.getPath());
    }

    @Test
    public void getMark() {
        Line newLine = new Line(1, 1, 1, 4);
        Assert.assertEquals(new Character('*'),newLine.getMark());
    }
}