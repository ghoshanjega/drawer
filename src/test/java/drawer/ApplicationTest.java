package drawer;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.security.Permission;


public class ApplicationTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    protected static class ExitException extends SecurityException
    {
        public final int status;
        public ExitException(int status)
        {
            super("There is no escape!");
            this.status = status;
        }
    }

    private static class NoExitSecurityManager extends SecurityManager
    {
        @Override
        public void checkPermission(Permission perm)
        {
            // allow anything.
        }
        @Override
        public void checkPermission(Permission perm, Object context)
        {
            // allow anything.
        }
        @Override
        public void checkExit(int status)
        {
            super.checkExit(status);
            throw new ExitException(status);
        }
    }

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        System.setSecurityManager(new NoExitSecurityManager());
    }

    @Test
    public void testMain() throws IOException {
        String[] args = null;
        final FileInputStream fips = new FileInputStream("./src/test/java/drawer/integration.txt");
        try {
            Application.start(fips,args);
        }
        catch (ExitException e){
            Assert.assertEquals("Exit status", 0, e.status);
            String expected = FileUtils.readFileToString(new File("./src/test/java/drawer/integrationExpected.txt"),"utf-8");
            Assert.assertEquals(expected, outputStreamCaptor.toString()
                    .trim());

        }
    }


}