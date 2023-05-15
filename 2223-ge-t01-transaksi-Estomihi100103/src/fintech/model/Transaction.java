package fintech.model;

/**
 * @author 12S21004 Estomihi Pangaribuan
 */
public class Transaction {

  private String account_name;
  private String owner;
  private double balance = 0.0;
  private int id = 0;
  private double amount;
  private String posted_at;
  private String note;

  public Transaction(String account_name, String ownwer, double amount, String posted_at, String note) {
    this.account_name = account_name;
    this.owner = ownwer;
    this.amount = amount;
    this.posted_at = posted_at;
    this.note = note;
  }

  public String toString() {
    return owner + "|" + account_name + "|" + +balance;
  }

  public String toString2() {
    return (id+1) + "|" + account_name + "|" + amount + "|" + posted_at + "|" + note + "|" + (balance + amount);
  }

}