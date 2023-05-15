package fintech.model;

/**
 * @author 12S21004 Estomihi Pangaribuan
 */

// <account-name>|<owner>|<balance>
public class Account {
    // <account-name>|<owner>|<balance>
    private String accountName;
    private String owner;
    private double balance = 0.0;

    public Account(String accountName, String owner) {
        this.accountName = accountName;
        this.owner = owner;

    }

    public String toString() {
        return owner + "|" + accountName + "|"  +balance;
    }

}