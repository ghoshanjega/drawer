package drawer.command;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UtilsTest {

    @Test
    public void toNumber() {
        Assert.assertEquals(54,Utils.toNumber("54"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void toNumberNegative() {
        Utils.toNumber("-54");
    }

    @Test(expected = IllegalArgumentException.class)
    public void toNumberWithString() {
        Utils.toNumber("s54");
    }
}