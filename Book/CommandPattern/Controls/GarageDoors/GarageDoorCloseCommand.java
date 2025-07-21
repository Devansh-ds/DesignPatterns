package Controls.GarageDoors;

import Controls.Command;

public class GarageDoorCloseCommand implements Command {

    GarageDoor door;

    public GarageDoorCloseCommand(GarageDoor door) {
        this.door = door;
    }

    @Override
    public void execute() {
        door.down();
    }

    public void undo() {
        door.up();
    }
    
}
