package Command;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommandPattern {
    public static void main(String[] args) {
        BankAccount ba = new BankAccount();
        System.out.println(ba);

        List<BankAccountCommand> commands = new ArrayList<>(
                    List.of(
                        new BankAccountCommand(ba, BankAccountCommand.Action.DEPOSIT, 100),
                        new BankAccountCommand(ba, BankAccountCommand.Action.WITHDRAW, 1000)
                    )
                );
        
        for (BankAccountCommand c: commands) {
            c.call();
            System.out.println(ba);
        }

        Collections.reverse(commands);
        for (Command c: commands) {
            c.undo();
            System.out.println(ba);
        }
    }
}

class BankAccount {
    private int balance;
    private int overdraftLimit = -500;

    public void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited " + amount + ", balance is now " + balance);
    }

    public boolean withdraw(int amount) {
        if (balance - amount >= overdraftLimit) {
            balance -= amount;
            System.out.println("Withdraw " + amount + ", balance is now " + balance);
            return true;
        }
        return false;
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

interface Command {
    void call();
    void undo();
}

class BankAccountCommand implements Command {
    private BankAccount account;
    private boolean succeeded;

    public enum Action { DEPOSIT, WITHDRAW }
    private Action action;
    private int amount;

    public BankAccountCommand(BankAccount account, Action action, int amount) {
        this.account = account;
        this.action = action;
        this.amount = amount;
    }

    @Override
    public void call() {
        switch (action) {
            case DEPOSIT:
                succeeded = true;
                account.deposit(amount);
                break;
            case WITHDRAW: 
                succeeded = account.withdraw(amount);
                break;
        }
    }

    @Override
    public void undo() {
        if (!succeeded) return;

        switch (action) {
            case DEPOSIT:
                account.withdraw(amount);
                break;
            case WITHDRAW:
                account.deposit(amount);
                break;
        }
    }
}