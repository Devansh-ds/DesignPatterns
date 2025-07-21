package Controls.Fan;

import Controls.Command;

public class CeilingFanOffCommand implements Command {

    private CeilingFan fan;

    public CeilingFanOffCommand(CeilingFan fan) {
        this.fan = fan;
    }

    public void execute() {
        fan.off();
    }

    public void undo() {
        fan.on();
    }
    
}
