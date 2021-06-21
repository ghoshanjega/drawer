package drawer.command;

import drawer.entity.Point;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SwitchBoardTest {
    private SwitchBoard switchBoard;

    @Before
    public void setUp() throws Exception {
        switchBoard = new SwitchBoard();
    }

    @Test
    public void inferCommandTypeLine() throws InvalidCommandException {
        Assert.assertTrue(switchBoard.inferCommandType("L 1 2 3 4") instanceof LineCommand);
    }

    @Test
    public void inferCommandTypeRectangle() throws InvalidCommandException {
        Assert.assertTrue(switchBoard.inferCommandType("R 1 2 3 4") instanceof RectangleCommand);
    }

    @Test
    public void inferCommandTypeQuit() throws InvalidCommandException {
        Assert.assertTrue(switchBoard.inferCommandType("Q") instanceof QuitProgramCommand);
    }

    @Test
    public void inferCommandTypeCanvas() throws InvalidCommandException {
        Assert.assertTrue(switchBoard.inferCommandType("C 1 2") instanceof CreateCanvasCommand);
    }

    @Test
    public void inferCommandTypeBucketFill() throws InvalidCommandException {
        Assert.assertTrue(switchBoard.inferCommandType("B 1 2 q") instanceof BucketFillCommand);
    }
}