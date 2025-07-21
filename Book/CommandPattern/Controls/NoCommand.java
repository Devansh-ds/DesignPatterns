package Controls;
public class NoCommand implements Command {

    public NoCommand() {
    }

    @Override
    public void execute() {
        System.out.println("---------Command is not set----------");
    }

    public void undo() {
        System.out.println("------UNDO what?------");
    }

}
