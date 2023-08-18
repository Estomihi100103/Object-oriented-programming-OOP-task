package fintech.model;

import java.util.*;

public class DrivAccount {
    public ArrayList<Account> saveAccounts = new ArrayList<Account>();
    public ArrayList<Transaction> saveTransactions = new ArrayList<Transaction>();

    // create account
    public void createAccount(String accountName, String owner, String cekName) {
        boolean cek = true;
        for (Account account : saveAccounts) {
            if (account.getAccountName().equals(cekName)) {
                cek = false;
                break;
            }
        }
        if (cek == true) {
            Account newAccount = new Account(accountName, owner);
            saveAccounts.add(newAccount);
            System.out.println(newAccount.toString());

        }

    }

    // find account
    public void findAccount(String accountName) {
        for (Account account : saveAccounts) {
            if (account.getAccountName().equals(accountName)) {
                System.out.println(account.toString());
                break;
            }
        }
    }

    public boolean cekAccount(String accountName) {
        boolean cek = false;
        for (Account account : saveAccounts) {
            if (account.getAccountName().equals(accountName)) {
                cek = true;
                break;
            }
        }
        return cek;
    }

    // sort by date
    public void SortByDate() {
        Collections.sort(saveTransactions, new Comparator<Transaction>() {
            public int compare(Transaction t1, Transaction t2) {
                return t1.getWaktuTransaksi().compareTo(t2.getWaktuTransaksi()); // baru

            }

        });
    }

    // sort by accountName
    public void SortByAccountName() {
        Collections.sort(saveAccounts, new Comparator<Account>() {
            public int compare(Account t1, Account t2) {
                return t1.getAccountName().compareTo(t2.getAccountName()); // baru

            }

        });
    }

    public void showAccount(String accountName) {
        for (Account account : saveAccounts) {
            if (account.getAccountName().equals(accountName)) {
                System.out.println(account.toString());
                break;
            }
        }

        SortByDate();
        for (Transaction transaction : saveTransactions) {
            if (transaction instanceof Withdrawal) {
                Withdrawal withdrawal = (Withdrawal) transaction;
                if (transaction.getAccountName().equals(accountName)
                        || withdrawal.getTargetAccount().equals(accountName)) {
                    System.out.println(transaction.toStringTran());
                }
            } else {
                if (transaction.getAccountName().equals(accountName)) {
                    System.out.println(transaction.toStringTran());
                }
            }

        }
    }

    // showAccounts all
    public void showAccounts() {
        SortByAccountName();
        SortByDate();
        for (Account account : saveAccounts) {
            System.out.println(account.toString());
            for (Transaction printTransaction : saveTransactions) {
                if (printTransaction instanceof Withdrawal) {
                    Withdrawal withdrawal = (Withdrawal) printTransaction;
                    if (printTransaction.getAccountName().equals(account.getAccountName())
                            || withdrawal.getTargetAccount().equals(account.getAccountName())) {
                        System.out.println(printTransaction.toStringTran());
                    }
                } else {
                    if (printTransaction.getAccountName().equals(account.getAccountName())) {
                        System.out.println(printTransaction.toStringTran());
                    }

                }
            }

        }
    }

    // remove-account#jasemb
    public void removeAccount(String accountName) {
        for (Account account : saveAccounts) {
            if (account.getAccountName().equals(accountName)) {
                saveAccounts.remove(account);
                break;
            }
        }

        for (Transaction transaction : saveTransactions) {
            if (transaction.getAccountName().equals(accountName)) {
                saveTransactions.remove(transaction);
                break;
            }
        }
    }

    // create-transaction#congcong#-5.0#2023/02/16 10:15:41#Tax
    public void createTransaction(String accountName, double amount, String date, String description) {
        for (Account account : saveAccounts) {
            if (account.getAccountName().equals(accountName)) {

                try {
                    Double balance = account.balance();
                    Double transactionAmount = amount;
                    performTransaction(balance, transactionAmount);
                    account.addSaldo(amount);
                    Transaction transaction = new Transaction(accountName, amount, date, description);
                    saveTransactions.add(transaction);
                    break;
                } catch (NegativeBalanceException e) {
                    // System.out.println(e.getMessage());
                }

            }

        }
    }

    // create-transaction#jaksem#milkyn#4.4#2023/02/24 15:04:51#Slide copy
    public void createTransaction_Transfer(String accountName, String targetAccount, double amount, String date,
            String description, int lengSplit) {
        boolean cek = false;
        if (amount >= 0) {
            for (Account account : saveAccounts) {
                if (account.getAccountName().equals(accountName)) {
                    if (account.balance() != 0.0) {
                        if (account.balance() - amount >= 0) {
                            cek = true;
                            account.setBalance(account.balance() - amount);
                            Transaction Withdrawal = new Withdrawal(accountName, targetAccount, amount, date,
                                    description);
                            saveTransactions.add(Withdrawal);
                        }
                    }
                }
            }
            if (cek == true) {
                for (Account account : saveAccounts) {
                    if (account.getAccountName().equals(targetAccount)) {
                        account.setBalance(account.balance() + amount);

                    }
                }
            }

        }

    }

    public class revertTransaction {
        String accountName;
        int index;
        String date;

        public revertTransaction() {
            this.accountName = "";
            this.index = 0;
            this.date = "";
        }

        public revertTransaction(String accountName, int index, String date) {
            this.accountName = accountName;
            this.index = index;
            this.date = date;
        }

        public String getAccountName() {
            return accountName;
        }

        public void setAccountName(String accountName) {
            this.accountName = accountName;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        // revert-transaction#jaksem#3#2023/02/15 15:15:16
        public void revertUang(String accountName, int index, String date) {
            Boolean cek = false;
            for (Transaction reveTransaction : saveTransactions) {
                if (reveTransaction.getId() == index) {
                    for (Account revertAccount : saveAccounts) {
                        if (revertAccount.getAccountName().equals(reveTransaction.getAccountName())) {
                            if (revertAccount.balance() >= reveTransaction.getAmount()) {
                                revertAccount.setBalance(revertAccount.balance() - reveTransaction.getAmount());
                                cek = true;
                            }

                        }
                    }
                }
                if (cek == true) {
                    Transaction newTransaction = new Transaction(reveTransaction.getAccountName(),
                            (-1) * reveTransaction.getAmount(), date, "REVERT: " + reveTransaction.getKeterangan());
                    saveTransactions.add(newTransaction);
                    break;
                }
            }
        }

    }

    public static void performTransaction(Double balance, Double transactionAmount) throws NegativeBalanceException {
        if (balance + transactionAmount < 0) {
            throw new NegativeBalanceException("Negative balance is not allowed!");
        }

    }

    public static class NegativeBalanceException extends Exception {
        public NegativeBalanceException(String message) {
            super(message);
        }
    }

}
