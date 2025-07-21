package Controls.GarageDoors;

import Controls.Command;

public class GarageDoorOpenCommand implements Command {

    GarageDoor door;

    public GarageDoorOpenCommand(GarageDoor door) {
        this.door = door;
    }

    @Override
    public void execute() {
        door.up();
    }

    public void undo() {
        door.down();
    }
    
}
