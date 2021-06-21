package drawer.entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RectangleTest {

    @Test
    public void create() throws Exception {
        new Rectangle(13, 18, 1, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createWithNegativeNumbers() throws Exception {
        new Rectangle(-1, 1, 1, 4);
    }

    @Test
    public void getEdges() {
        Rectangle newRectangle = new Rectangle(13, 18, 1, 4);
        Line[] expectedLines = new Line[]{
                new Line(13,18,1,1),
                new Line(18,18,1,4),
                new Line(18,13,4,4),
                new Line(13,13,4,1),
        };
        Assert.assertEquals(expectedLines,newRectangle.getEdges());
    }
}