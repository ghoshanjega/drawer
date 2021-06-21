package drawer.command;

import org.junit.Assert;
import org.junit.Test;


public class InvalidCommandExceptionTest {

    @Test
    public void getMessage() {
        InvalidCommandException newException = new InvalidCommandException("This is a message");
        Assert.assertEquals("This is a message",newException.getMessage());
    }
}