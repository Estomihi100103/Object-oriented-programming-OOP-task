package fintech.driver;

/**
 * @author 12S21004 Estomihi Pangaribuan
 */

import java.util.Scanner;
import fintech.model.*;

public class Driver1 {
    public static void main(String[] args) {
        DrivAccount driveAccount = new DrivAccount();
        Scanner scan = new Scanner(System.in);
        String str;

        while (true) {
            str = scan.nextLine();
            if (str.equals("---")) {
                break;
            } else {
                String[] arrOfStr = str.split("#");
                if (arrOfStr[0].equals("create-account")) {
                    driveAccount.createAccount(arrOfStr[2], arrOfStr[1], arrOfStr[2]);
                } else if (arrOfStr[0].equals("find-account")) {
                    arrOfStr[1] = arrOfStr[1].toLowerCase();
                    driveAccount.findAccount(arrOfStr[1]);
                } else if (arrOfStr[0].equals("create-transaction")) {
                    arrOfStr[1] = arrOfStr[1].toLowerCase();
                    try {
                        Double amount = Double.parseDouble(arrOfStr[2]);
                        driveAccount.createTransaction(arrOfStr[1], amount, arrOfStr[3], arrOfStr[4]);
                    } catch (NumberFormatException e) {
                        System.out.println("Input tidak valid, masukkan angka yang valid.");
                    }
                } else if (arrOfStr[0].equals("show-account")) {
                    arrOfStr[1] = arrOfStr[1].toLowerCase();
                    driveAccount.showAccount(arrOfStr[1]);
                } else if (str.startsWith("show-accounts")) {
                    driveAccount.showAccounts();
                } else if (arrOfStr[0].equals("remove-account")) {
                    arrOfStr[1] = arrOfStr[1].toLowerCase();
                    driveAccount.removeAccount(arrOfStr[1]);
                }

            }
        }
        scan.close();
    }

}
