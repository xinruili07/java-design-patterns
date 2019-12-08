import java.util.ArrayList;
import java.util.List;

public class CompositeCommand implements Command
{
    private List<Command> aCommands = new ArrayList<>();

    public CompositeCommand(Command... pCommands )
    {
        for( Command command : pCommands )
        {
            aCommands.add(command);
        }
    }

    @Override
    public void execute()
    {
        for( Command command : aCommands )
        {
            command.execute();
        }
    }
}