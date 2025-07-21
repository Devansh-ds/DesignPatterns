package Controls.Fan;

import Controls.Command;

public class CeilingFanOnCommand implements Command {

    private CeilingFan fan;

    public CeilingFanOnCommand(CeilingFan fan) {
        this.fan = fan;
    }

    public void execute() {
        fan.on();
    }
    
    public void undo() {
        fan.off();
    }
}
