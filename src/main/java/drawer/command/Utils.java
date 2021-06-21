package drawer.command;

public class Utils {
    public static int  toNumber (String parameter) throws IllegalArgumentException{
        try {
            int i = Integer.parseInt(parameter);
            if (i < 0)
                throw new NumberFormatException("Non positive integers found as arguments");
            return i;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
