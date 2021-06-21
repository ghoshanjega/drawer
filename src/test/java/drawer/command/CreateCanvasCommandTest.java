package drawer.command;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class CreateCanvasCommandTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void newCanvas() throws InvalidCommandException {
        String[] command = new String[]{"C", "25", "5"};
        new CreateCanvasCommand(command);
    }

    @Test(expected = InvalidCommandException.class)
    public void newInvalidCanvas1() throws InvalidCommandException {
        String[] command = new String[]{"C", "25"};
        new CreateCanvasCommand(command);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newInvalidCanvas2() throws InvalidCommandException {
        String[] command = new String[]{"C", "-225", "5"};
        new CreateCanvasCommand(command);
    }


    @Test
    public void print() throws InvalidCommandException {
        String[] command = new String[]{"C", "25", "5"};
        CreateCanvasCommand newCanvas = new CreateCanvasCommand(command);
        newCanvas.print();

        Assert.assertEquals("Blank Canvas of width 25 and height 5", outputStreamCaptor.toString()
                .trim());
    }

    @Test
    public void getWidth() throws InvalidCommandException {
        String[] command = new String[]{"C", "25", "5"};
        Assert.assertEquals(25,new CreateCanvasCommand(command).getWidth());
    }

    @Test
    public void getHeight() throws InvalidCommandException {
        String[] command = new String[]{"C", "25", "5"};
        Assert.assertEquals(5,new CreateCanvasCommand(command).getHeight());
    }
}