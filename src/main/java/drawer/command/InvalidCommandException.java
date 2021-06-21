package drawer.command;

public class InvalidCommandException extends Throwable {
    String message;

    public InvalidCommandException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage(){
        return this.message;
    }
}
