package Memento;

public class MementoPatternn {
    public static void main(String[] args) {
        BankAccount ba = new BankAccount(100);
        Memento m1 = ba.deposit(50);
        Memento m2 = ba.deposit(25);
        System.out.println(ba);

        // restore to m1
        ba.restore(m1);
        System.out.println(ba);

        // restore to m2
        ba.restore(m2);
        System.out.println(ba);
    }
}

class Memento {
    
    public int balance; 

    public Memento(int balance) {
        this.balance = balance;
    }
}

class BankAccount {
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public Memento deposit(int amount) {
        balance += amount;
        return new Memento(balance);
    }

    public void restore(Memento memento) {
        balance = memento.balance;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BankAccount{");
        sb.append("balance=").append(balance);
        sb.append('}');
        return sb.toString();
    }
}