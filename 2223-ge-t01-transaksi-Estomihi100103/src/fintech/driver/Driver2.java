package fintech.driver;

import fintech.model.Account;
import fintech.model.Transaction;
import java.util.Scanner;

/**
 * @author 12S21004 Estomihi Pangaribuan
 */
public class Driver2 {

    public static void main(String[] _args) {
        Scanner input = new Scanner(System.in);
        String perintah;
        String accountName;
        String testaccountName;
        String owner;
        String perintah2;
        double amount=0.0;
        String posted_at="";
        String note="";


        perintah = input.nextLine();
        owner = input.nextLine();
        accountName = input.nextLine();
        perintah2 = input.nextLine();
        testaccountName = input.nextLine();

        if (accountName.equals(testaccountName)) {
            amount = input.nextDouble();
            input.nextLine();
            posted_at = input.nextLine();
            note = input.nextLine();
        }

        Transaction transactions = new Transaction(accountName, owner, amount, posted_at, note);
        System.out.println(transactions.toString());
        System.out.println(transactions.toString2());

    }
}