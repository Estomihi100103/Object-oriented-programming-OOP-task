package pbo.fintech;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.*;
import pbo.fintech.model.*;

/**
 * 12S21002 - Dhino Turnip
 * 12S21004 - Estomihi Pangaribuan
 * 
 * To compile:
 * mvn clean compile assembly:single
 * 
 * To run:
 * java -cp .\target\fintech-1.0-SNAPSHOT-jar-with-dependencies.jar
 * pbo.fintech.App
 */
public class App {
    private static EntityManagerFactory factory;
    private static EntityManager entityManager;

    public static void main(String[] _args) {
        // codes
        factory = Persistence.createEntityManagerFactory("fintech_pu");
        entityManager = factory.createEntityManager();
        drivAccount.initializeEntityManager();

        drivAccount.cleanTable(); // Bersihkan tabel
        drivAccount.cleanTableTransaction(); // Bersihkan tabel

        String str, str2;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            str = scanner.nextLine();
            str2 = str;
            if (str.equals("---")) {
                break;
            } else {
                String[] arrOfStr = str.split("#");
                if (arrOfStr[0].equals("create-account")) {
                    drivAccount.createAccount(arrOfStr[2], arrOfStr[1], arrOfStr[2]);
                } else if (arrOfStr[0].equals("show-accounts")) {
                    drivAccount.displayAllAccount();
                } else if (arrOfStr[0].equals("remove-account")) {
                    drivAccount.removeAccount(arrOfStr[1]);
                } else if (arrOfStr[0].equals("find-account")) {
                    drivAccount.findAccountByName(arrOfStr[1]);
                } else if (arrOfStr[0].equals("create-transaction")) {
                    arrOfStr[1] = arrOfStr[1].toLowerCase();
                    try {
                        Double amount = Double.parseDouble(arrOfStr[2]);
                        drivAccount.createTransaction(arrOfStr[1], amount, arrOfStr[3], arrOfStr[4]);
                    } catch (NumberFormatException e) {
                        System.out.println("Input tidak valid, masukkan angka yang valid.");
                    }
                }
            }
        }
        entityManager.close();
        factory.close();
    }
}