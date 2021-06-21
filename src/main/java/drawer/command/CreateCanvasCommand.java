package drawer.command;

public class CreateCanvasCommand extends Command {
    final static int COMMAND_COUNT = 3;
    private int width, height;

    public CreateCanvasCommand(String[] command) throws InvalidCommandException, IllegalArgumentException {
        super('C');
        if (command.length < COMMAND_COUNT) throw  new InvalidCommandException("Expected format => C [width] [height]");
            width = Utils.toNumber(command[1]);
            height = Utils.toNumber(command[2]);

    }

    public int getWidth(){
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    @Override
    public void print() {
        System.out.println(this.getMethodSignature()+" of width " + width + " and height " + height);
    }
}
