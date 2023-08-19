package pbo.fintech.model;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @Column(name = "accountName", nullable = false, length = 255)
    private String accountName;

    @OneToMany(mappedBy = "accounts", cascade = CascadeType.ALL)
    private Set<Transaction> transactions;

    @Column(name = "owner", nullable = false, length = 255)
    private String owner;

    @Column(name = "balance", nullable = true, length = 255)
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

    public String getAccountName() {
        return accountName;
    }

    public void addSaldo(double amount) {
        this.balance += amount;
    }

    public double balance() {
        return balance;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        transaction.setAccount(this);
    }
}
