package fintech.model;

public class Account {
    private String accountName;
    private String owner;
    private double balance;

    public Account() {
        this.accountName = "";
        this.owner = "";
        this.balance = 0.0;
    }

    public Account(String accountName, String owner) {
        this.accountName = accountName;
        this.owner = owner;
        this.balance = 0.0;
    }

    public String toString() {
        return accountName + "|" + owner + "|" + String.format("%.1f", balance);
    }

    // getAccountName
    public String getAccountName() {
        return accountName;
    }

    public void addSaldo(double amount) {
        this.balance += amount;
    }

    public void subSaldo(double amount) {
        this.balance -= amount;
    }

    // setBalance
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // getBalance
    public double balance() {
        return balance;
    }

}
