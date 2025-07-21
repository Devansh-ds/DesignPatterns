package Controls.Lights;

public class Light {
    private String type;

    public Light() {
        type = "";
    }

    public Light(String type) {
        this.type = type;
    }

    public void on() {
        System.out.println(type + "Light ON");
    }

    public void off() {
        System.out.println(type + "Light OFF");
    }
}
