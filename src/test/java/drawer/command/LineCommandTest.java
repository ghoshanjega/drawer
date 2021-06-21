package drawer.command;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class LineCommandTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void newLine() throws Exception, InvalidCommandException {
        String[] command = new String[]{"L","1","1","5","5"} ;
        new LineCommand(command);
    }

    @Test(expected = InvalidCommandException.class)
    public void newInvalidLine1() throws Exception, InvalidCommandException {
        String[] command = new String[]{"L","1","1","5"} ;
        new LineCommand(command);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newInvalidLine2() throws Exception, InvalidCommandException {
        String[] command = new String[]{"L","-1","1","5","5"} ;
        new LineCommand(command);
    }

    @Test
    public void print() throws Exception, InvalidCommandException {
        String[] command = new String[]{"L","1","1","5","5"} ;
        LineCommand newLine = new LineCommand(command);
        newLine.print();

        Assert.assertEquals("New Line from (1,1) to (5,5)", outputStreamCaptor.toString()
                .trim());
    }
}