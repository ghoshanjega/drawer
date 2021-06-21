package drawer.command;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class RectangleCommandTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void newLine() throws IllegalArgumentException, InvalidCommandException {
        String[] command = new String[]{"R","1","1","5","5"} ;
        new RectangleCommand(command);
    }

    @Test(expected = InvalidCommandException.class)
    public void newInvalidLine1() throws Exception, InvalidCommandException {
        String[] command = new String[]{"R","1","1","5"} ;
        new RectangleCommand(command);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newInvalidLine2() throws  InvalidCommandException {
        String[] command = new String[]{"R","-1","1","5","5"} ;
        new RectangleCommand(command);
    }

    @Test
    public void print() throws InvalidCommandException {
        String[] command = new String[]{"R","1","1","5","5"} ;
        RectangleCommand newLine = new RectangleCommand(command);
        newLine.print();

        Assert.assertEquals("New Rectangle from (1,1) to (5,5)", outputStreamCaptor.toString()
                .trim());
    }
}