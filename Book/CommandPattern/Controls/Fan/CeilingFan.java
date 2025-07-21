package Controls.Fan;

public class CeilingFan {

    private String type;

    public CeilingFan() {
        type = "";
    }

    public CeilingFan(String type) {
        this.type = type;
    }

    public void on() {
        System.out.println(type + " fan is on");
    }

    public void off() {
        System.out.println(type + " fan is off");
    }
    
}
