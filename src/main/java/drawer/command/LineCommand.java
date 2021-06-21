package drawer.command;

import java.security.InvalidParameterException;

public class LineCommand extends Command {
    final static int COMMAND_COUNT = 5;
    private int x1, x2, y1, y2;

    LineCommand(String[] command) throws InvalidCommandException,IllegalArgumentException {
        super('L');
        if (command.length < COMMAND_COUNT)
            throw new InvalidCommandException("Expected format => L [x1] [y1] [x2] [y2]");
            x1 = Utils.toNumber(command[1]);
            x2 = Utils.toNumber(command[3]);
            y1 = Utils.toNumber(command[2]);
            y2 = Utils.toNumber(command[4]);
    }

    @Override
    public void print() {
        System.out.println(this.getMethodSignature() + " from (" + x1 + "," + y1 + ") to (" + x2 + "," + y2 + ")");
    }

    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    public int getY1() {
        return y1;
    }

    public int getY2() {
        return y2;
    }

}
