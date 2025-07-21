package Controls.Stereos;

public class Stereo {

    private String type;

    public Stereo() {
        type = "";
    }

    public Stereo(String type) {
        this.type = type;
    }

    public void on() {
        System.out.println(type + " stereo is on");
    }
    
    public void setCD() {
        System.out.println(type + " sterro cd is set");
    }

    public void off() {
        System.out.println(type + " stereo is off");
    }
}
