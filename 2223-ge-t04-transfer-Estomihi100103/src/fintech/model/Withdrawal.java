package fintech.model;

public class Withdrawal extends Transaction {
    private String targetAccount = null;

    public Withdrawal(String accountName, String targetAccount, double amount, String postedAt, String note) {
        super(accountName, amount, postedAt, note);
        this.targetAccount = targetAccount;

    }

    public String getTargetAccount() {
        return targetAccount;
    }

    public String toStringTran() {
        if (targetAccount != null) {
            return getId() + "|" + getAccountName() + "|" + targetAccount + "|" + getAmount() + "|" + getPostedAt() + "|" + getNote();
        }
        return null;
  
    }

}
