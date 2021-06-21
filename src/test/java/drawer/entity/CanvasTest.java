package drawer.entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class CanvasTest {
    private Canvas canvas;

    @Before
    public void setUp() throws Exception {
        canvas = new Canvas(25, 5);
    }

    @Test
    public void createEmptyCanvas() throws Exception {
        Assert.assertEquals(canvas.printCanvas(),
                "---------------------------\n" +
                        "|                         |\n" +
                        "|                         |\n" +
                        "|                         |\n" +
                        "|                         |\n" +
                        "|                         |\n" +
                        "---------------------------");
    }

    @Test
    public void addOnePixelInsideCanvas() throws Exception {
        Point point = new Point(1,1);
        canvas.addPixel(point,'*');
        Assert.assertEquals(canvas.printCanvas(),
                "---------------------------\n" +
                        "|                         |\n" +
                        "| *                       |\n" +
                        "|                         |\n" +
                        "|                         |\n" +
                        "|                         |\n" +
                        "---------------------------");
    }

    @Test
    public void addTw0PixelInsideCanvas() throws Exception {
        Point point1 = new Point(1,1);
        canvas.addPixel(point1,'*');
        Point point2 = new Point(1,2);
        canvas.addPixel(point2,'*');
        Assert.assertEquals(canvas.printCanvas(),
                "---------------------------\n" +
                        "|                         |\n" +
                        "| *                       |\n" +
                        "| *                       |\n" +
                        "|                         |\n" +
                        "|                         |\n" +
                        "---------------------------");
    }

    @Test
    public void addOnePixelOutsideCanvas() throws Exception {
        Point point = new Point(5,25);
        canvas.addPixel(point,'*');
        Assert.assertEquals(canvas.printCanvas(),
                "---------------------------\n" +
                        "|                         |\n" +
                        "|                         |\n" +
                        "|                         |\n" +
                        "|                         |\n" +
                        "|                         |\n" +
                        "---------------------------");
    }





}
