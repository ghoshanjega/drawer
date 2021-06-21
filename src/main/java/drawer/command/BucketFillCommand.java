package drawer.command;

public class BucketFillCommand extends Command {
    final static int COMMAND_COUNT = 4;
    private int x, y;
    private char color;

    BucketFillCommand(String[] command) throws InvalidCommandException, IllegalArgumentException{
        super('B');
        if (command.length < COMMAND_COUNT)
            throw new InvalidCommandException("Expected format => B [x] [y] [color]");
        x = Utils.toNumber(command[1]);
        y = Utils.toNumber(command[2]);
        color = command[3].charAt(0);
    }

    @Override
    public void print() {
        System.out.println(this.getMethodSignature() + " at (" + x + "," + y + ") with color " + color);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getColor() {
        return color;
    }
}
