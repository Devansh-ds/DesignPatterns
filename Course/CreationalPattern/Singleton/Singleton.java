package CreationalPattern.Singleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Singleton {
    public static void main(String[] args) throws Exception {
        // serailaization
        BasicSingleton singleton = BasicSingleton.getObject();
        singleton.setValue(1);

        String filename = "singleton.bin";
        saveToFile(singleton, filename);

        singleton.setValue(222);
        BasicSingleton singleton2 = readFromFile(filename);

        System.out.println(singleton == singleton2);
        System.out.println(singleton.getValue() == singleton2.getValue());

        // error in constructor
        StaticBlockSingleton errorSingleton = StaticBlockSingleton.getInstance();
    }

    static void saveToFile(BasicSingleton singleton, String filename) throws Exception {
        try (FileOutputStream fout = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(fout)) {
                out.writeObject(singleton);
        }
    }

    static BasicSingleton readFromFile(String filename) throws Exception {
        try (FileInputStream fin = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fin)) {
                return (BasicSingleton) in.readObject();
             }
    }
}

class BasicSingleton implements Serializable {
    private static final BasicSingleton INSTANCE = new BasicSingleton();

    private BasicSingleton() {
    }

    public static BasicSingleton getObject() {
        return INSTANCE;
    }

    private int value = 0;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    protected Object readResolve() {
        return INSTANCE;
    }
}

class StaticBlockSingleton {

    private StaticBlockSingleton() throws IOException {
        System.out.println("Singleton is initialize");
        File file = File.createTempFile(".", ".");
    }

    private static StaticBlockSingleton instance;

    static {
        try {
            instance = new StaticBlockSingleton();
        } catch (Exception e) {
            System.err.println("Failed to create singleton");
        }
    }

    public static StaticBlockSingleton getInstance() {
        return instance;
    }
}

class LazySingleton {
    private static LazySingleton instance;
    private LazySingleton() {}

    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}

class InnerStaticSingleton {
    private InnerStaticSingleton() {}

    private static class Impl {
        private static final InnerStaticSingleton INSTANCE = new InnerStaticSingleton();
    }

    public InnerStaticSingleton getInstance() {
        return Impl.INSTANCE;
    }
}