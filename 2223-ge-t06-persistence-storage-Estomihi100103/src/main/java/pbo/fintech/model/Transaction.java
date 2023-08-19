package pbo.fintech.model;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "transaction_entity")
public class Transaction {
    private static int nextId = 1;

    @Id
    @Column(name = "id", nullable = false, length = 255)
    private int id;

    @ManyToOne
    @JoinColumn(name = "accountName", referencedColumnName = "accountName", insertable = false, updatable = false)
    private Account accounts;

    @Column(name = "accountName", nullable = false, length = 255)
    private String accountName;

    @Column(name = "amount", nullable = false, length = 255)
    private double amount;

    @Column(name = "postedAt", nullable = false, length = 255)
    private String postedAt;

    @Column(name = "note", nullable = false, length = 255)
    private String note;

    public Transaction(String accountName, double amount, String postedAt, String note) {
        this.id = nextId++;
        this.accountName = accountName;
        this.amount = amount;
        this.postedAt = postedAt;
        this.note = note;
    }

    public Transaction() {
        // Konstruktor default
    }

    public int getId() {
        return id;
    }

    public String getWaktuTransaksi() {
        return postedAt;
    }

    public String getAccountName() {
        return accountName;
    }

    public double getAmount() {
        return amount;
    }

    public String getPostedAt() {
        return postedAt;
    }

    public String getNote() {
        return note;
    }

    public void setAccount(Account account) {
        this.accounts = account;
    }

    public String toStringTran() {
        return id + "|" + accountName + "|" + amount + "|" + postedAt + "|" + note;
    }
}
