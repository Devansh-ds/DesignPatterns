package Controls.Stereos;

import Controls.Command;
import Controls.Stereos;

public class SetereoOnCommand implements Command {

    private Stereo stereo;

    public SetereoOnCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    public void execute() {
        stereo.on();
        stereo.setCD();
    }

    public void undo() {
        stereo.off();
    }
    
}
