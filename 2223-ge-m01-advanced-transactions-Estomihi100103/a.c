// package fintech.driver;

// import java.util.Collections;
// import java.util.Scanner;
// import fintech.model.*;
// import java.util.LinkedList;
// import java.util.ArrayList;
// import java.util.Comparator;

// /**
//  * @author 12S21001 Dhino rayaldo turnip
//  * @author 12S21004 Estomihi Pangaribuan
//  */

// public class Driver1 {

//     public static void main(String[] args) {
//         LinkedList<Account> saveAccounts = new LinkedList<Account>();
//         ArrayList<Transaction> makeTran = new ArrayList<Transaction>();
//         ArrayList<Transaction> transaksiList = new ArrayList<Transaction>();

//         String perintah;
//         Scanner input = new Scanner(System.in);

//         while (true) {
//             perintah = input.nextLine();
//             String splitt[] = perintah.split("#");

//             if (perintah.equals("---")) {
//                 break;
//             }



//             else if (perintah.startsWith("create-account")) {
//                 String split[] = perintah.split("#");
//                 // jika nama akun sudah ada
//                 boolean canAdd = true;
//                 for (Account account1 : saveAccounts) {
//                     if (account1.getAccountName().equals(split[2])) {
//                         canAdd = false;
//                         break;
//                     }
//                 }

//                 if (canAdd) {
//                     Account account = new Account(split[1], split[2]);
//                     saveAccounts.add(account);
//                     System.out.println(account.toString());
//                 }

//             } else if (perintah.startsWith("find-account")) {
//                 String split[] = perintah.split("#");
//                 split[1] = split[1].toLowerCase();
//                 for (Account account : saveAccounts) {
//                     if (account.getAccountName().equals(split[1])) {
//                         System.out.println(account.toString());
//                     }
//                 }
//                 //create-transaction#jaksem#15.0#2023/02/14 14:14:14#Weekly income

//             } else if (perintah.startsWith("create-transaction")) {
//                 String split[] = perintah.split("#");
//                 double amount = Double.parseDouble(split[2]);
//                 String namaalias = split[1];
//                 namaalias = namaalias.toLowerCase();

//                 // BalanceInsufficientException
//                 for (Account account : saveAccounts) {
//                     if (account.getAccountName().toLowerCase().equals(namaalias)) {
//                         if (account.getBalance() + amount > 0) {
//                             account.addSaldo(amount);
//                             Transaction transaction = new Transaction(split[1], Double.parseDouble(split[2]), split[3],
//                                     split[4]);
//                             makeTran.add(transaction);
//                             break;
//                         } else {
//                             try {
//                                 throw new Handling();
//                             } catch (Handling e) {
//                                 //e.printStackTrace();
//                             }
//                         }
//                     }
//                 }

//             } else if (splitt[0].equals("show-account")) {
//                 String split[] = perintah.split("#");
//                 split[1] = split[1].toLowerCase();

//                 for (Account account : saveAccounts) {
//                     if (account.getAccountName().equals(split[1])) {
//                         System.out.println(account.toString());
//                     }

//                 }

//                 for (Transaction transaction : makeTran) {
//                     if (transaction.getAccountName().equals(split[1])) {
//                         transaksiList.add(transaction);

//                     }

//                 }
//                 Collections.sort(transaksiList, new Comparator<Transaction>() {
//                     public int compare(Transaction t1, Transaction t2) {
//                         return t1.getWaktuTransaksi().compareTo(t2.getWaktuTransaksi());
//                     }

//                 });

//                 for (Transaction transaction : transaksiList) {
//                     if (transaction.getAccountName().equals(split[1])) {
//                         System.out.println(transaction.toStringTran());
//                     }

//                 }

//                 // show-accounts
//             } else if (splitt[0].equals("show-accounts")) {
//                 Collections.sort(saveAccounts, new Comparator<Account>() {
//                     public int compare(Account a1, Account a2) {
//                         return a1.getAccountName().compareTo(a2.getAccountName());
//                     }

//                 });
//                 Collections.sort(makeTran, new Comparator<Transaction>() {
//                     public int compare(Transaction t1, Transaction t2) {
//                         return t1.getWaktuTransaksi().compareTo(t2.getWaktuTransaksi());
//                     }

//                 });

//                 for (Account account : saveAccounts) {
//                     System.out.println(account.toString());
//                     for (Transaction transaction : makeTran) {
//                         if (transaction.getAccountName().equals(account.getAccountName())) {
//                             System.out.println(transaction.toStringTran());
//                         }

//                     }

//                 }
//                 // remove-account#jasemb
//             } else if (splitt[0].equals("remove-account")) {
//                 String split[] = perintah.split("#");
//                 split[1] = split[1].toLowerCase();
//                 for (Account account : saveAccounts) {
//                     if (account.getAccountName().equals(split[1])) {
//                         saveAccounts.remove(account);
//                         break;
//                     }
//                 }
//                 for (Transaction transaction : makeTran) {
//                     if (transaction.getAccountName().equals(split[1])) {   
//                         makeTran.remove(transaction);
//                         break;
//                     }
//                 }

//             }

//         }

//         input.close();

//     }


    
// }
