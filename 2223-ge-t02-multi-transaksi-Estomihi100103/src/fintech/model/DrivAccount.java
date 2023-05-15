package fintech.model;

import java.util.ArrayList;

public class DrivAccount {
    public ArrayList<Account> saveAccounts = new ArrayList<Account>();

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

    //create-transaction#congcong#-5.0#2023/02/16 10:15:41#Tax
    public void createTransaction(String accountName, double amount, String date, String description) {
        for (Account account : saveAccounts) {
            if (account.getAccountName().equals(accountName)) {
                account.addSaldo(amount);
                break;
            }
        }
    }
}
