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
        return accountName + "|" + owner + "|" + balance;
    }

    // getAccountName
    public String getAccountName() {
        return accountName;
    }

    public void addSaldo(double amount) {
        this.balance += amount;
    }

    //getBalance
    public double balance() {
        return balance;
    }

}
