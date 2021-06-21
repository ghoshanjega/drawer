package drawer.command;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class BucketFillCommandTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }


    @Test
    public void print() throws InvalidCommandException {
        String[] command = new String[]{"B","1","1","q"} ;
        BucketFillCommand newBucketFill = new BucketFillCommand(command);
        newBucketFill.print();

        Assert.assertEquals("New Bucket Fill at (1,1) with color q", outputStreamCaptor.toString()
                .trim());
    }

    @Test
    public void getX() throws InvalidCommandException {
        String[] command = new String[]{"B","1","1","q"} ;
        BucketFillCommand newBucketFill = new BucketFillCommand(command);
        Assert.assertEquals(1,newBucketFill.getX());
    }

    @Test
    public void getY() throws InvalidCommandException {
        String[] command = new String[]{"B","1","1","q"} ;
        BucketFillCommand newBucketFill = new BucketFillCommand(command);
        Assert.assertEquals(1,newBucketFill.getY());
    }

    @Test
    public void getColor() throws InvalidCommandException {
        String[] command = new String[]{"B","1","1","q"} ;
        BucketFillCommand newBucketFill = new BucketFillCommand(command);
        Assert.assertEquals('q',newBucketFill.getColor());
    }
}