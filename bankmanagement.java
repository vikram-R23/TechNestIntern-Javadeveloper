abstract class Account {
    protected String accountNumber;
    protected double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);

    public void displayBalance() {
        System.out.println("Account " + accountNumber + " Balance: " + balance);
    }
}

class SavingsAccount extends Account {
    private double interestRate = 0.03;

    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void deposit(double amount) {
        balance += amount + (amount * interestRate);
        System.out.println("Deposited to SavingsAccount: " + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn from SavingsAccount: " + amount);
        } else {
            System.out.println("Insufficient balance in SavingsAccount.");
        }
    }
}

class CurrentAccount extends Account {
    private double overdraftLimit = 500;

    public CurrentAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited to CurrentAccount: " + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (balance + overdraftLimit >= amount) {
            balance -= amount;
            System.out.println("Withdrawn from CurrentAccount: " + amount);
        } else {
            System.out.println("Overdraft limit exceeded in CurrentAccount.");
        }
    }
}

public class bankmanagement {
    public static void main(String[] args) {
        Account acc1 = new SavingsAccount("SA123", 1000);
        Account acc2 = new CurrentAccount("CA456", 2000);

        acc1.deposit(500);
        acc1.withdraw(200);
        acc1.displayBalance();

        acc2.deposit(1000);
        acc2.withdraw(3000);
        acc2.displayBalance();
    }
}
