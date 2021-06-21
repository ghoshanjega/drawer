package drawer.command;

public class SwitchBoard {
    public Command inferCommandType (String line) throws InvalidCommandException {
        String[] command = parse(line.trim());
        switch (command[0].toUpperCase()){

            case "C":
                return new CreateCanvasCommand(command);
            case "L":
                return new LineCommand(command);
            case "R":
                return new RectangleCommand(command);
            case "B":
                return new BucketFillCommand(command);
            case "Q":
                return new QuitProgramCommand();
            default:
                throw new InvalidCommandException("Not a recognized command");
        }
    }

    private String[] parse (String line) {
        return line.split("\\s+");
    }
}
