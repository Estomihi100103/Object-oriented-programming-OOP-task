package fintech.driver;

import fintech.model.Account;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Collection;

/**
 * @author 12S21004 Estomihi Pangaribuan
 */
public class Driver1 {

    public static void main(String[] _args) {
        Scanner input = new Scanner(System.in);
        String perintah;
        String accountName;
        String owner;

        perintah = input.nextLine();
        accountName = input.nextLine();
        owner = input.nextLine();

        Account accounts = new Account(accountName, owner);
        System.out.println(accounts.toString());

    }
}