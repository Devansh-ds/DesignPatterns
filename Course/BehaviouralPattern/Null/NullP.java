package Null;

import java.lang.reflect.Proxy;

public class NullP {
    public static void main(String[] args) {
        // Log log = new NullLog();
        Log log = noOp(Log.class);
        BankAccount ba = new BankAccount(log);

        ba.deposit(100);
    }

    @SuppressWarnings("unchecked")
    public static <T> T noOp(Class<T> itf) {
        return (T) Proxy.newProxyInstance(
            itf.getClassLoader(),
            new Class<?>[] { itf },
            (proxy, method, args) -> {
                if (method.getReturnType().equals(Void.TYPE)) return null;
                else return method.getReturnType().getConstructor().newInstance();
            }
        );
    }
}

interface Log {
    void info(String msg);
    void warn(String msg);
}

class ConsoleLog implements Log {

    @Override
    public void info(String msg) {
        System.out.println("INFO: " + msg);
    }

    @Override
    public void warn(String msg) {
        System.out.println("WARN: " + msg);
    }
}

final class NullLog implements Log {

    @Override
    public void info(String msg) {
        // Do nothing
    }

    @Override
    public void warn(String msg) {
        // Do nothing
    }
}

class BankAccount {
    private Log log;
    private int balance;

    public BankAccount(Log log) {
        this.log = log;
    }

    public void deposit(int amount) {
        balance += amount;

        log.info("deposited " + amount);
    }
}