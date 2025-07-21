public class MainFirst {
    public static void main(String[] args) {
        System.out.println("hsd");
        Singleton obj = Singleton.getInstance();
        System.out.println(obj);
        System.out.println(Singleton.getInstance());
        System.out.println(Singleton.getInstance());
    }
}

class Singleton {

    private static Singleton uniqueInstance;

    private Singleton() {
        System.out.println("In constructor");
    }

    public static Singleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }

    @Override
    public String toString() {
        return "this is a toString().";
    }


}