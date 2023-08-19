package pbo.fintech.model;

import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class drivAccount {
    private static EntityManagerFactory factory;
    private static EntityManager entityManager;
    public static ArrayList<Account> saveAccounts = new ArrayList<Account>();
    public static ArrayList<Transaction> saveTransactions = new ArrayList<Transaction>();

    public static void initializeEntityManager() {
        factory = Persistence.createEntityManagerFactory("fintech_pu");
        entityManager = factory.createEntityManager();
    }

    public static void cleanTable() {
        String jpql = "DELETE FROM Account a";
        entityManager.getTransaction().begin();
        int deleteAccounts = entityManager.createQuery(jpql).executeUpdate();
        entityManager.flush();
        entityManager.getTransaction().commit();
        // System.out.println("Data akun berhasil dihapus! :" + deleteAccounts);
    }

    public static void displayAllAccount() {
        String jpql = "SELECT a FROM Account a ORDER BY a.accountName";
        List<Account> accounts = entityManager.createQuery(jpql, Account.class)
                .getResultList();
        // System.out.println("Data akun: ");

        for (Account a : accounts) {
            System.out.println(a.toString());
        }
    }

    // remove-account#jasemb
    public static void removeAccount(String accountName) {
        accountName = accountName.toLowerCase();

        initializeEntityManager();
        entityManager.getTransaction().begin();

        Account accounts = entityManager.find(Account.class, accountName);
        if (accounts != null) {
            entityManager.remove(accounts);
            entityManager.getTransaction().commit();
            // System.out.println("Akun berhasil dihapus: " + accountName);
        } else {
            entityManager.getTransaction().rollback();
            // System.out.println("Akun tidak ditemukan: " + accountName);
        }

    }

    public static void findAccountByName(String accountName) {
        String jpql = "SELECT a FROM Account a WHERE lower(a.accountName) = lower(:accountName)";
        List<Account> accounts = entityManager.createQuery(jpql, Account.class)
                .setParameter("accountName", accountName)
                .getResultList();
        if (accounts.isEmpty()) {
            // System.out.println("Account dengan nama " + accountName + " tidak
            // ditemukan.");
        } else {
            // System.out.println("Account dengan nama " + accountName + ":");
            for (Account a : accounts) {
                System.out.println(a.toString());
            }
        }
    }

    // create account
    public static void createAccount(String accountName, String owner, String cekName) {
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
            entityManager.getTransaction().begin();
            entityManager.persist(newAccount);
            entityManager.flush();
            entityManager.getTransaction().commit();
            System.out.println(newAccount.toString());

        }

    }

    public static void createTransaction(String accountName, double amount, String date, String description) {
        accountName = accountName.toLowerCase();
        initializeEntityManager();
        entityManager.getTransaction().begin();

        Account accounts = entityManager.find(Account.class, accountName);
        if (accounts != null) {
            Transaction newTransaction = new Transaction(accountName, amount, date, description);
            accounts.addSaldo(amount);
            entityManager.persist(newTransaction);
            entityManager.flush();
            entityManager.getTransaction().commit();
            // System.out.println("Transaksi berhasil dibuat: " +
            // newTransaction.toStringTran());
        } else {
            entityManager.getTransaction().rollback();
            // System.out.println("Akun tidak ditemukan: " + accountName);
        }
    }

    public static void cleanTableTransaction() {
        String jpql = "DELETE FROM Transaction t";
        entityManager.getTransaction().begin();
        int deleteTransaction = entityManager.createQuery(jpql).executeUpdate();
        entityManager.flush();
        entityManager.getTransaction().commit();
        //
        // System.out.println("Data transaction berhasil dihapus! :" +
        // deleteTransaction);
    }

}
