import java.util.ArrayList;
import java.util.List;

public class LoggedCommand implements Command {

    private final Command aCommand;
    private final String aMessage;

    public LoggedCommand(Command command, String message) {
        aCommand = command;
        aMessage = message;
    }

    @Override
    public void execute() {
        aCommand.execute();
        System.out.println(aMessage);
    }
}
