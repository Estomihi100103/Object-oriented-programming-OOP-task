package fintech.driver;

/**
 * @author 12S21001 Dhino Rayvaldo Turnip
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
                // create-account#Wiro Sableng#wirsab
                String[] arrOfStr = str.split("#");
                if (arrOfStr[0].equals("create-account")) {
                    driveAccount.createAccount(arrOfStr[2], arrOfStr[1], arrOfStr[2]);
                }
            }
        }
        scan.close();
    }

}
