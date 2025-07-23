
import java.io.Serializable;

public class CloneSerialization {
    public static void main(String[] args) {
        Foo f1 = new Foo(4, "yo");
        // SerailizationUtils will give a clone() function.
    }
}

class Foo implements Serializable {

    public int stuff;
    public String what;

    public Foo(int stuff, String what) {
        this.stuff = stuff;
        this.what = what;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Foo{");
        sb.append("stuff=").append(stuff);
        sb.append(", what=").append(what);
        sb.append('}');
        return sb.toString();
    }

    

}