package State;

public class StateClassic {
    public static void main(String[] args) {
        LightSwitch ls = new LightSwitch();
        ls.on();
        ls.off();
        ls.on();
    }
}

class State {

    void on(LightSwitch ls) {
        System.out.println("Light turned on");
    } 

    void off(LightSwitch ls) {
        System.out.println("Light turned off");
    }
}

class OnState extends State {
    public OnState() {
        System.out.println("Light turned ON");
    }

    @Override
    public void off(LightSwitch ls) {
        System.out.println("Switching light off...");
        ls.setState(new OffState());
    }
}

class OffState extends State {
    public OffState() {
        System.out.println("Light turned OFF");
    }

    @Override
    public void on(LightSwitch ls) {
        System.out.println("Switching light on...");
        ls.setState(new OnState());
    }
}

class LightSwitch {
    private State state;

    public LightSwitch() {
        state = new OffState();
    }

    void on() {
        state.on(this);
    }

    void off() {
        state.off(this);
    }

    public void setState(State state) {
        this.state = state;
    }
}