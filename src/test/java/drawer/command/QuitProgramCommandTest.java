package drawer.command;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class QuitProgramCommandTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void newQuit() throws Exception, InvalidCommandException {
        new QuitProgramCommand();
    }

    @Test
    public void print() {
        QuitProgramCommand newQuit = new QuitProgramCommand();
        newQuit.print();

        Assert.assertEquals("Exit", outputStreamCaptor.toString()
                .trim());
    }
}