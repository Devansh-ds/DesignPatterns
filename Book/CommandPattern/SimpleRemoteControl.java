import Controls.Command;
import Controls.NoCommand;

public class SimpleRemoteControl {

    Command[] onCommands;
    Command[] offCommands;
    Command undoCommand;

    public SimpleRemoteControl() {
        onCommands = new Command[7];
        offCommands = new Command[7];

        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand = noCommand;
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    public void undoButtonWasPushed() {
        undoCommand.undo();
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append("\n-----Remote Control----\n");
        for (int i = 0; i < onCommands.length; i++) {
            str
            .append("[slot ").append(i).append("] ")
            .append(onCommands[i].getClass().getName())
            .append("    ")
            .append(offCommands[i].getClass().getName())
            .append("\n");
        }
        str
            .append("[undo] ")
            .append(undoCommand.getClass().getName())
            .append("\n");
        return str.toString();
    }
    
}
