package drawer.command;

import java.util.HashMap;
import java.util.Map;

public abstract class Command {
    private char method;
    Map<Character, String> cmdMap = new HashMap<Character, String>() {{
        put('L', "New Line");
        put('Q', "Quit");
        put('R', "New Rectangle");
        put('C', "Blank Canvas");
        put('B', "New Bucket Fill");
    }};


    Command (char method) {
        this.method = method;
    }

    public abstract void print ();

    public String getMethodSignature() {
        return cmdMap.get(method);
    }
}
