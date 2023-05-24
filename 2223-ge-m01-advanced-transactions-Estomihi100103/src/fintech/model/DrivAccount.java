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
        Collections.sort(saveTransactions, (t1, t2) -> t1.getWaktuTransaksi().compareTo(t2.getWaktuTransaksi()));
    }

    // sort by accountName
    public void SortByAccountName() {
        Collections.sort(saveAccounts, (t1, t2) -> t1.getAccountName().compareTo(t2.getAccountName()));
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
            if (transaction.getAccountName().equals(accountName)) {
                System.out.println(transaction.toStringTran());

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
                if (printTransaction.getAccountName().equals(account.getAccountName())) {
                    System.out.println(printTransaction.toStringTran());
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

                // if (account.balance() + amount >= 0) {
                // account.addSaldo(amount);
                // Transaction transaction = new Transaction(accountName, amount, date,
                // description);
                // saveTransactions.add(transaction);
                // break;
                // }

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
