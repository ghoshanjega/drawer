package drawer.command;

public class QuitProgramCommand  extends Command{

    QuitProgramCommand() {
        super('Q');
    }

    @Override
    public void print() {
        System.out.println("Exit");
    }
}
