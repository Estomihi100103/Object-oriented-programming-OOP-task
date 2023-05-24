package fintech.model;

/**
 * @author NIM Nama
 * @author NIM Nama
 */

public class Transaction {
    private static int nextId = 1;

    private int id;
    private String accountName;
    private double amount;
    private String postedAt;
    private String note;

    public Transaction(String accountName, double amount, String postedAt, String note) {
        this.id = nextId++;
        this.accountName = accountName;
        this.amount = amount;
        this.postedAt = postedAt;
        this.note = note;
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

    

    public String toStringTran() {

        return id + "|" + accountName + "|" + amount + "|" + postedAt + "|" + note;
    }
}
